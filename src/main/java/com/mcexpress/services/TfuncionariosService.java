package com.mcexpress.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcexpress.domain.Tfuncionarios;
import com.mcexpress.repositories.TfuncionariosRepository;
import com.mcexpress.services.exceptions.ObjectNotFountException;

//anotação de serviço do springboot
@Service
public class TfuncionariosService {


	@Autowired
	private TfuncionariosRepository repo;
	
	public Tfuncionarios findById(Integer id) {
		Optional<Tfuncionarios> obj = repo.findById(id);
		
		//Agora o meu método de serviço lança uma exceção caso o id não exista, porém o rest tem 
		//que capturar a exceção e enviar um JSON apropriado para a resposta HTTP do meu recurso
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tfuncionarios.class.getName()));
																//tipo do objeto que trouxe essa exceção					
	}


	public List<Tfuncionarios> findFuncionarios() {

		return repo.findFuncionarios(true);

	}
	
	public List<Tfuncionarios> findOperador() {
		
		return repo.findOperador(true);
		
	}
	
	public Tfuncionarios findUsuarioPorNome(String nome) {
		
		return repo.findUsuarioPorNome(nome);
	}

}
