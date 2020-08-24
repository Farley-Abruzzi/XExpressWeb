package com.mcexpress.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mcexpress.domain.Tusuarios;
import com.mcexpress.repositories.TusuariosRepository;

@Service
public class TusuariosService {

	@Autowired
	private BCryptPasswordEncoder pe;

//	pe.encode(objDto.getSenha());

	@Autowired
	private TusuariosRepository repo;

	// =================================Usuário código máximo de incremento no BD Firebird=============
	public Integer findMax() {
		Integer obj = repo.findMax();
		return obj;
		// tipo do objeto que trouxe essa exceção
	}

	public Tusuarios insert(Tusuarios obj) {

		// tratar exceção caso banco for vazio
		try {
			Integer codUsuario = findMax() + 1;
			// apontar proximo id do feriado
			obj.setCODUSUARIO(codUsuario);
			
			String senha = pe.encode(obj.getSENHAJAVA());
			obj.setSENHAJAVA(senha);
			 

			return repo.save(obj);
		} catch (Exception e) {
			// apontar id inicial do banco
			obj.setCODUSUARIO(1);
			return repo.save(obj);
		}
	}

}
