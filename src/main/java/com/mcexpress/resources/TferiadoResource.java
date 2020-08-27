package com.mcexpress.resources; // o nome Resources é utilizado para criar a classe de controlador rest

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mcexpress.domain.Tferiado;
import com.mcexpress.services.TferiadoService;

@RestController
@RequestMapping(value = "/feriado")
public class TferiadoResource {
	
	@Autowired //Instanciar automaticamente
	private TferiadoService service;
	
	
	//=================================Feriado por id=============	
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Tferiado> find(@PathVariable Integer id) { 
		
		Tferiado obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		//Exemplo URL: http://localhost:8081/feriado/1
		//consulta por id do feriado
	}
	
	//======Feriado com Paginação camada de serviço não implementada======
	@CrossOrigin
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Tferiado>> findIdPage(
			@RequestParam(value="cod", defaultValue = "6") Integer cod,
			@RequestParam(value="page", defaultValue = "0")Integer page,  
			@RequestParam(value="linesPerPage", defaultValue = "25")Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue = "IMPRESSO")String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC")String direction) {
		
		Page<Tferiado> listPage = service.findIdPage(cod, page, linesPerPage, orderBy, direction);

		return ResponseEntity.ok().body(listPage);
		//http://localhost:8081/feriado/page?cod=303
	}
	
	//==================================Feriado com Lista=========
	@CrossOrigin
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<List<Tferiado>> findIdList(){
		
		List<Tferiado> list = service.findIdList();
		return ResponseEntity.ok().body(list);
		 //http://localhost:8081/feriado/list
	}

	
	//========================Inserir novo feriado=================
	@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR')")
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST) //A anotação @Valid indica que o metodo irá usar o BeanValidation na Trecibos DTO
	public ResponseEntity<Void> insert(@Valid @RequestBody Tferiado obj){ //Para o objeto ser construido a partir dos dados JSON que eu enviar é preciso a anotação antes da variável @RequestBody 
		
		obj = service.insert(obj);
		
		//O HTTP quando estou inserindo um novo recurso há um codigo de resposta particular, o codigo adequado é 201 Created
		//Vamos usar a chave da categoria para inserir a URL HTTP
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCODFERIADO()).toUri();
		// o fromCurrentRequest pega o URL base ex: "http://localhost:8081/feriado" e o buildAndExpand() o id do objeto Inserido.
		
		return ResponseEntity.created(uri).build();
		
		
		/*Modelo a ser inserido
		{
		    "dataferiado": "2020-02-22",
		    "estado": "Amazonas",
		    "replicar": 0,
		    "descricao": "Feriado prolongado de carnaval",
		    "cidade": "Alvarães"
		}*/
		
		// http://localhost:8081/feriado
	}
		
	//========================Atualizar novo feriado=================
	@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR')")
	@CrossOrigin
	@RequestMapping(value="/{id}" , method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Tferiado obj, @PathVariable Integer id){
		
		
		obj.setCODFERIADO(id); //Para garantir que a categoria a ser atualizada é realmente a que foi passada como parâmetro
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		System.out.println("\n\nDados da atualização\n\n " + sdf.format(obj.getDATAFERIADO()));
		
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
		// http://localhost:8081/feriado/1
	}
	
	//========================Excluir feriado=================
	@PreAuthorize("hasAnyRole('ADMIN', 'SUPERVISOR')")
	@CrossOrigin
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) { 
		
		service.delete(id);
		return ResponseEntity.noContent().build();
		// http://localhost:8081/feriado/1
	}
	
	/*
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TrecibosDTO>> findAll() {
		List<Trecibos> list = service.findAll();
		//Preciso percorrer a lista list e para cada elemento dela instanciar o DTO (id e nome) correspondentes,
		//depois vou percorrer usando o recurso do java 8 "stream", e usar o map (fazer uma operação para cada elemento da lista)
		//que tera um apelido (obj) usando "(->) uma função anonima que recebe o objeto e instancia o TrecibosDTO
		//passanso o obj como argumento, depois voltar o stream de objeto para o tipo lista usando o ".collect(Collectors.toList()"
		List<TrecibosDTO> listDTO = list.stream().map(obj -> new TrecibosDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}
	*/

}
