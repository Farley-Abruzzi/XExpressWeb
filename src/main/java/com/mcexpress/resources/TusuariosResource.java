package com.mcexpress.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mcexpress.domain.Tusuarios;
import com.mcexpress.services.TusuariosService;

@RestController
@RequestMapping(value = "/usuario")
public class TusuariosResource {
		
	@Autowired
	private TusuariosService service;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST) //A anotação @Valid indica que o metodo irá usar o BeanValidation na Trecibos DTO
	public ResponseEntity<Void> insert(@RequestBody Tusuarios obj) { //Para o objeto ser construido a partir dos dados JSON que eu enviar é preciso a anotação antes da variável @RequestBody
	
		obj = service.insert(obj);
	
		//O HTTP quando estou inserindo um novo recurso há um codigo de resposta particular, o codigo adequado é 201 Created
		//Vamos usar a chave da categoria para inserir a URL HTTP
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getCODUSUARIO()).toUri();
		// o fromCurrentRequest pega o URL base ex: "http://localhost:8081/depositos" e o buildAndExpand() o id do objeto Inserido.
		
		return ResponseEntity.created(uri).build();
		// http://localhost:8081/deposito
			
	}
}
