package com.mcexpress.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mcexpress.domain.Trecdevolvidosweb;
import com.mcexpress.repositories.TrecdevolvidoswebRepository;
import com.mcexpress.services.exceptions.DataIntegrityException;
import com.mcexpress.services.exceptions.ObjectNotFountException;

//anotação de serviço do springboot
@Service
public class TrecdevolvidoswebService {

	@Autowired
	private TrecdevolvidoswebRepository repo;

	// =================================Feriado por id=============
	public Trecdevolvidosweb find(Integer id) {
		Optional<Trecdevolvidosweb> obj = repo.findId(id);

		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Trecdevolvidosweb.class.getName()));
		// tipo do objeto que trouxe essa exceção
	}

	// =================================Feriado código máximo de incremento no BD
	// Firebird=============

	public Integer findMax() {
		Integer obj = repo.findMax();
		return obj;
		// tipo do objeto que trouxe essa exceção
	}

	// =================================Feriado com Paginação======
	public Page<Trecdevolvidosweb> findIdPage(Integer cod, Integer page, Integer linesPerPage, String orderBy,
			String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findIdPage(cod, pageRequest);

	}

	// ==================================Feriado com Lista=========
	public List<Trecdevolvidosweb> findIdList() {

		List<Trecdevolvidosweb> list = repo.findIdList();
		return list;
	}

	public Trecdevolvidosweb insert(Trecdevolvidosweb obj) {

		return repo.save(obj);

	}

	public Trecdevolvidosweb update(Trecdevolvidosweb obj) {
		// objeto monitorado pelo JPA
		find(obj.getNrorecibo());
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
