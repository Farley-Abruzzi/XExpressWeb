package com.mcexpress.resources;

import java.net.URI;

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

import com.mcexpress.domain.Tcontribuintes;
import com.mcexpress.dto.TcontribuintesDTO;
import com.mcexpress.dto.TcontribuintesDTO2;
import com.mcexpress.resources.utils.URL;
import com.mcexpress.services.TcontribuintesService;

//, consumes={"application/json"}

@RestController
@RequestMapping(value = "/contribuintes")
public class TcontribuintesResource {
	
	@Autowired
	private TcontribuintesService service; 
	
	// ========================================Contribuinte por ID

	@CrossOrigin //Anotação de Cors Cross-Origin Resource Sharing (CORS) 
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TcontribuintesDTO> findByCodcontrib(@PathVariable Integer id) { 
	
		Tcontribuintes obj = service.findByCodcontrib(id);
		TcontribuintesDTO objDto = new TcontribuintesDTO(obj);
		
		objDto.setSTATUS(obj.getSTATUS().getDESCSTATUS());
		
		return ResponseEntity.ok().body(objDto);
		//URL contribuintes por ID: http://localhost:8081/contribuintes/33
	}
	
	// ========================================O último contribuinte cadastrado
	
	@CrossOrigin //Anotação de Cors Cross-Origin Resource Sharing (CORS)
	@RequestMapping(value="/ultcontrib", method=RequestMethod.GET)
	public ResponseEntity<TcontribuintesDTO2> ultContribInserido() {
		
		Integer idObj = service.findMax();
		Tcontribuintes obj = service.findByCodcontrib(idObj);
		TcontribuintesDTO2 objDTO2 = new TcontribuintesDTO2(obj);
		
		return ResponseEntity.ok().body(objDTO2);
	}
	
	// ========================================Contribuinte por ID com page
	
	@CrossOrigin
	@RequestMapping(value="/porid", method=RequestMethod.GET)
	public ResponseEntity<Page<TcontribuintesDTO>> findByCodcontribPage(
			@RequestParam(value="id", defaultValue = "")Integer id,
			@RequestParam(value="page", defaultValue = "0")Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "25")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "NOME")String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC")String direction) { 
	
		Page<Tcontribuintes> list = service.findByCodcontribPage(id, page, linesPerPage, orderBy, direction);
		Page<TcontribuintesDTO> listDTO = list.map(obj -> new TcontribuintesDTO(obj));
		
		return ResponseEntity.ok().body(listDTO);
		//URL contribuintes por ID: http://localhost:8081/contribuintes/porid?id=33
	}	
	
	
	// ========================================Contribuinte ativos por Paginação 
	
	@CrossOrigin
	@RequestMapping(value="/page", method=RequestMethod.GET) 
	public ResponseEntity<Page<TcontribuintesDTO>> findPageContrib(
			@RequestParam(value="page", defaultValue = "0")Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "25")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "NOME")String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC")String direction
			){
		
		Page<Tcontribuintes> list = service.findPageContrib(page, linesPerPage, orderBy,direction);
		Page<TcontribuintesDTO> listDTO = list.map(obj -> new TcontribuintesDTO(obj));
		return ResponseEntity.ok().body(listDTO);
		
		//com paginação o parametro vem antes do request
		
		//URL de teste: http://localhost:8081/contribuintes/page?
	}
	

	// ========================================Contribuinte ativos por Paginação e com filtro COBRANÇA = 1, IMPRESSÃO = 2 OPERAÇÃO = 3 REPIQUE = 4
	@CrossOrigin
	@RequestMapping(value="/paginacao", method=RequestMethod.GET) 
	public ResponseEntity<Page<TcontribuintesDTO>> findPage(
			@RequestParam(value="status", defaultValue = "1")Integer status,
			@RequestParam(value="page", defaultValue = "0")Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "25")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "NOME")String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC")String direction
			){
		
		Page<Tcontribuintes> list = service.findPage(status, page, linesPerPage, orderBy,direction);
		Page<TcontribuintesDTO> listDTO = list.map(obj -> new TcontribuintesDTO(obj));
		return ResponseEntity.ok().body(listDTO);
		
		//com paginação o parametro vem antes do request
		//URL de teste: http://localhost:8081/contribuintes/paginacao?&status=1&page=1&linesPerPage=3
	}
	
	
	// Contribuintes por nome
	@CrossOrigin
	@RequestMapping(value="/bucarpornome", method=RequestMethod.GET) 
	public ResponseEntity<Page<TcontribuintesDTO2>> findPageList(
			@RequestParam(value="nome", defaultValue = "")String nome,
			@RequestParam(value="page", defaultValue = "0")Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "25")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "NOME")String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC")String direction){
		
		String nomeDecoded = URL.decodeParam(nome);
		nomeDecoded = nomeDecoded.toUpperCase();
		
		Page<Tcontribuintes> list = service.findPageList(nomeDecoded, page,linesPerPage, orderBy,direction);
		Page<TcontribuintesDTO2> listDTO = list.map(obj -> new TcontribuintesDTO2(obj));
		
		System.out.println("\n\nNome da pesquisa: " + nome + "\n\n");
		
		return ResponseEntity.ok().body(listDTO);
		
		//com paginação o parametro vem antes do request
	    //URL de teste: http://localhost:8081/contribuintes/bucarpornome?nome=eli
	}
		
	public String func(String id) {
		return "ok";
		
	}
	
	// Contribuintes por endereço
	@CrossOrigin
	@RequestMapping(value="/bucarporendereco", method=RequestMethod.GET) 
	public ResponseEntity<Page<TcontribuintesDTO2>> findPageEndereco(
			@RequestParam(value="endereco", defaultValue = "")String endereco,
			@RequestParam(value="page", defaultValue = "0")Integer page, 
			@RequestParam(value="linesPerPage", defaultValue = "25")Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue = "NOME")String orderBy, 
			@RequestParam(value="direction", defaultValue = "ASC")String direction){
		
		String enderecoDecoded = URL.decodeParam(endereco);
		enderecoDecoded = enderecoDecoded.toUpperCase();
		
		Page<Tcontribuintes> list = service.findPageEndereco(enderecoDecoded, page,linesPerPage, orderBy,direction);
		Page<TcontribuintesDTO2> listDTO = list.map(obj -> new TcontribuintesDTO2(obj));
		return ResponseEntity.ok().body(listDTO);
		
		//com paginação o parametro vem antes do request
		
		//URL de teste: http://localhost:8081/contribuintes/bucarporendereco?endereco=eli
	}
	
	//========================Inserir novo contribuinte =================
	@PreAuthorize("hasAnyRole('ADMIN', 'OPERADORA')")
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST) //A anotação @Valid indica que o metodo irá usar o BeanValidation na Trecibos DTO
	public ResponseEntity<Void> insert(@RequestBody Tcontribuintes obj){ //Para o objeto ser construido a partir dos dados JSON que eu enviar é preciso a anotação antes da variável @RequestBody 
		
		obj = service.insert(obj);
		
		
		//O HTTP quando estou inserindo um novo recurso há um codigo de resposta particular, o codigo adequado é 201 Created
		//Vamos usar a chave da categoria para inserir a URL HTTP
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodcontrib()).toUri();
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
		
		// http://localhost:8081/contribuintes
	}
	
	//========================Atualizar contribuinte=================
		
	/*
	@RequestMapping(value="/{id}" , method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody TcontribuintesDTO objDto, @PathVariable Integer id){
		
		Tcontribuintes obj = service.fromDTO(objDto);
		obj.setId(id); //Para garantir que a categoria a ser atualizada é realmente a que foi passada como parâmetro
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) { 
		
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}*/
	
}

//Doc JPA Spring methods: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
