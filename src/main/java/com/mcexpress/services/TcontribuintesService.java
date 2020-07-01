package com.mcexpress.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mcexpress.domain.Tcontribuintes;
import com.mcexpress.repositories.TcontribuintesRepository;
import com.mcexpress.services.exceptions.DataIntegrityException;
import com.mcexpress.services.exceptions.ObjectNotFountException;

//anotação de serviço do springboot
@Service
public class TcontribuintesService {

	@Autowired
	private TcontribuintesRepository repo;

	// ========================================Contribuinte por ID
	
	public Tcontribuintes findByCodcontrib(Integer id) {
		Optional<Tcontribuintes> obj = repo.findByCodcontrib(id);
		
		//Agora o meu método de serviço lança uma exceção caso o id não exista, porém o rest tem 
		//que capturar a exceção e enviar um JSON apropriado para a resposta HTTP do meu recurso
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tcontribuintes.class.getName()));
																//tipo do objeto que trouxe essa exceção					
	}
	
	// ========================================Contribuinte por ID page
	
	public Page<Tcontribuintes> findByCodcontribPage(Integer id, Integer page, Integer linesPerPage, String orderBy, String direction) {
		
		//Optional<Tcontribuintes> obj = repo.findByCodcontrib(id);
		
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		
		return repo.findByCodcontribPage(id, pageRequest);				
	}
	
	
	// ========================================Contribuinte ativos por Paginação
	
	public Page<Tcontribuintes> findPageContrib(Integer page, Integer linesPerPage, String orderBy, String direction){
		//para retornar uma página de dados preciso criar um objeto pageRequest
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		
		return repo.findPageContrib(pageRequest);
		//agora retornei o repositorio passando o pagerequest como argumento
		
	}
	
	
	// ========================================Contribuinte ativos por Paginação e com filtro COBRANÇA = 1, IMPRESSÃO = 2 OPERAÇÃO = 3 REPIQUE = 4
	
	public Page<Tcontribuintes> findPage(Integer status , Integer page, Integer linesPerPage, String orderBy, String direction){
		//para retornar uma página de dados preciso criar um objeto pageRequest
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		
		return repo.findPage(status, pageRequest);
		//agora retornei o repositorio passando o pagerequest como argumento
		
	}
	
	// Contribuintes por nome
	public Page<Tcontribuintes> findPageList(String nome , Integer page, Integer linesPerPage, String orderBy, String direction){
		//para retornar uma página de dados preciso criar um objeto pageRequest
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		
		return repo.findPageList(nome, pageRequest);
		//agora retornei o repositorio passando o pagerequest como argumento
	}
	
	// Contribuintes por endereço
	public Page<Tcontribuintes> findPageEndereco(String endereco , Integer page, Integer linesPerPage, String orderBy, String direction){
		//para retornar uma página de dados preciso criar um objeto pageRequest
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);
		
		return repo.findPageEndereco(endereco, pageRequest);
		//agora retornei o repositorio passando o pagerequest como argumento
	}
	
	public Integer findMax() {
		Integer obj = repo.findMax();
		return obj;
		// tipo do objeto que trouxe essa exceção
	}
	
	public Tcontribuintes insert(Tcontribuintes obj) {
		
		//tratar exceção caso banco for vazio
		try{
			Integer codContrib = findMax()+1;
			//apontar proximo id do feriado
			obj.setCodcontrib(codContrib);

			return repo.save(obj);
		}catch (Exception e) {
			//apontar id inicial do banco
			obj.setCodcontrib(1);
			return repo.save(obj);
		}

	}
	
	public Tcontribuintes update(Tcontribuintes obj) {
		//objeto monitorado pelo JPA
		findByCodcontrib(obj.getCodcontrib());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		findByCodcontrib(id); 
		try {
			repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um contribuinte que possui recibos");
		}
	}
	
	public List<Tcontribuintes> findAll(){
		
		return repo.findAll();
		
	}
	
	/*//método auxiliar que instancia uma categoria a partir de um dto.
	public Tcontribuintes fromDTO(TcontribuintesDTO objDto) {
		return new Tcontribuintes(objDto.getId(), objDto.getNome());
	}
	
	private void updateData(Tcontribuintes newObj, Tcontribuintes obj) { //método de dentro da classe
		newObj.setNome(obj.getNome());
	}*/
	
}
