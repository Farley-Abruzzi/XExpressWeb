package com.mcexpress.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mcexpress.domain.Tferiado;
import com.mcexpress.repositories.TferiadoRepository;
import com.mcexpress.services.exceptions.DataIntegrityException;
import com.mcexpress.services.exceptions.ObjectNotFountException;

//anotação de serviço do springboot
@Service
public class TferiadoService {

	@Autowired
	private TferiadoRepository repo;

	//=================================Feriado por id=============
	public Tferiado find(Integer id) {
		Optional<Tferiado> obj = repo.findId(id);

		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tferiado.class.getName()));
		// tipo do objeto que trouxe essa exceção
	}
	
	//=================================Feriado código máximo de incremento no BD Firebird=============
	
	public Integer findMax() {
		Integer obj = repo.findMax();
		return obj;
		// tipo do objeto que trouxe essa exceção
	}

	//=================================Feriado com Paginação======
	public Page<Tferiado> findIdPage(Integer cod, Integer page, Integer linesPerPage, String orderBy,
			String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findIdPage(cod, pageRequest);

	}

	//==================================Feriado com Lista=========
	public List<Tferiado> findIdList() {

		List<Tferiado> list = repo.findIdList();
		return list;
	}
	

	public Tferiado insert(Tferiado obj) {
		
		
		//tratar exceção caso banco for vazio
		try{
			Integer codFeriado = findMax()+1;
			//apontar proximo id do feriado
			obj.setCODFERIADO(codFeriado);

			return repo.save(obj);
		}catch (Exception e) {
			//apontar id inicial do banco
			obj.setCODFERIADO(1);
			return repo.save(obj);
		}

	}

	public Tferiado update(Tferiado obj) {
		// objeto monitorado pelo JPA
		find(obj.getCODFERIADO());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o feriado");
		}
	}

}
