package com.mcexpress.resources; // o nome Resources é utilizado para criar a classe de controlador rest

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcexpress.domain.Tfuncionarios;
import com.mcexpress.dto.TfuncionariosDTO;
import com.mcexpress.dto.TusuarioDTO;
import com.mcexpress.resources.utils.URL;
import com.mcexpress.services.TfuncionariosService;

@RestController
@RequestMapping(value = "/funcionarios")
public class TfuncionariosResource {
	
	
	@Autowired //Instanciar automaticamente
	private TfuncionariosService service;


	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TfuncionariosDTO>> findFuncionarios() { 
		
		List<Tfuncionarios> list = service.findFuncionarios();
		List<TfuncionariosDTO> listDto = (list.stream().map(obj-> new TfuncionariosDTO(obj)).collect(Collectors.toList()));
		
		
		return ResponseEntity.ok().body(listDto);
		//Exemplo URL: http://localhost:8081/funcionarios
		//consulta por Id Mensageiro
	}
	
	@CrossOrigin
	@RequestMapping(value = "/operadores", method=RequestMethod.GET)
	public ResponseEntity<List<TfuncionariosDTO>> findOperador() {
		
		List<Tfuncionarios> listOperadores = service.findOperador();
		List<TfuncionariosDTO> listDtoOperadores = (listOperadores.stream().map(obj -> new TfuncionariosDTO(obj)).collect(Collectors.toList()));
		
		return ResponseEntity.ok().body(listDtoOperadores);
		//Exemplo URL: http://localhost:8081/funcionarios/operadores
		//consulta operador por id do funcionario
		
	}
	
	// Busca usuário por nome completo ***
	@CrossOrigin
	@RequestMapping(value = "/usuariopornome", method=RequestMethod.GET)
	public ResponseEntity<TusuarioDTO> findUsuarioPorNome(
			@RequestParam(value = "nome", defaultValue = "")String nome) {
		
		String nomeDecoded = URL.decodeParam(nome);
		nomeDecoded = nomeDecoded.toUpperCase();
		
		Tfuncionarios obj = service.findUsuarioPorNome(nomeDecoded);
		TusuarioDTO objDto = new TusuarioDTO(obj);
		
		System.out.println("\n\nNome da pesquisa: " + nomeDecoded + "\n\n");
		
		return ResponseEntity.ok().body(objDto);
		//Exepmlo URL: http://localhost:8081/funcionarios/usuariopornome?nome=eli
	}
	
}
