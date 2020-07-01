package com.mcexpress.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mcexpress.domain.Thistoricorecibo;
import com.mcexpress.repositories.ThistoricoReciboRepository;
import com.mcexpress.services.exceptions.DataIntegrityException;
import com.mcexpress.services.exceptions.ObjectNotFountException;

//anotação de serviço do springboot
@Service
public class ThistoricoReciboService {

	@Autowired
	private ThistoricoReciboRepository repo;

	//=================================Feriado por id=============
	public Thistoricorecibo find(Integer id) {
		Optional<Thistoricorecibo> obj = repo.findId(id);

		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Thistoricorecibo.class.getName()));
		// tipo do objeto que trouxe essa exceção
	}
	
	//=================================Feriado código máximo de incremento no BD Firebird=============
	
	public Integer findMax() {
		Integer obj = repo.findMax();
		return obj;
		// tipo do objeto que trouxe essa exceção
	}

	//=================================Feriado com Paginação======
	public Page<Thistoricorecibo> findIdPage(Integer cod, Integer page, Integer linesPerPage, String orderBy,
			String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findIdPage(cod, pageRequest);

	}

	//==================================Feriado com Lista=========
	public List<Thistoricorecibo> findIdList() {

		List<Thistoricorecibo> list = repo.findIdList();
		return list;
	}
	

	public Thistoricorecibo insert(Thistoricorecibo obj) {
		
		
		//tratar exceção caso banco for vazio
		try{
			Integer codHistRec = findMax()+1;
			//apontar proximo id do feriado
			obj.setNrorecibo(codHistRec);

			return repo.save(obj);
		}catch (Exception e) {
			//apontar id inicial do banco
			obj.setNrorecibo(1);
			return repo.save(obj);
		}

	}

	public Thistoricorecibo update(Thistoricorecibo obj) {
		// objeto monitorado pelo JPA
		find(obj.getNrorecibo());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir esse historico do recibo");
		}
	}

}
