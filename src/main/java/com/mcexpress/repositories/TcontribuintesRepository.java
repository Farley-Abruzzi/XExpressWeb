package com.mcexpress.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mcexpress.domain.Tcontribuintes;

//anotação para classe e transformá-la em uma interface e herança de JPAREpository do Spring
@Repository
public interface TcontribuintesRepository extends JpaRepository<Tcontribuintes, Integer>  {
	
	// ========================================Contribuinte por ID
	Optional<Tcontribuintes> findByCodcontrib(Integer codcontrib);
	
	// ========================================Contribuinte por ID page
	
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Tcontribuintes obj WHERE obj.codcontrib =:id ") 
	Page<Tcontribuintes> findByCodcontribPage(
			@Param("id") Integer id, Pageable pageRequest);
	
	// ========================================Contribuinte ativos por Paginação
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Tcontribuintes obj WHERE obj.STATUS.CODSTATUS = 1") 
	Page<Tcontribuintes> findPageContrib(
			Pageable pageRequest);
	
	
	// ========================================Contribuinte ativos por Paginação e com filtro COBRANÇA = 1, IMPRESSÃO = 2 OPERAÇÃO = 3 REPIQUE = 4
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Tcontribuintes obj WHERE obj.STATUSSISTEMA.CODSTATUS =:status AND obj.STATUS.CODSTATUS = 1") 
	Page<Tcontribuintes> findPage(
			@Param("status") Integer status, Pageable pageRequest);
	
	
	// Contribuintes por nome
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Tcontribuintes obj "
			+ "WHERE obj.NOMENORECIBO like %:nome% ") 
	Page<Tcontribuintes> findPageList(
			@Param("nome") String nome, Pageable pageRequest);
	

	// Contribuintes por endereço
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Tcontribuintes obj "
			+ "WHERE obj.ENDERECOPRINCIPAL like %:endereco%") 
	Page<Tcontribuintes> findPageEndereco(
			@Param("endereco") String endereco, Pageable pageRequest);
	
	
	//=================================Contribuinte código máximo de incremento no BD Firebird=============
	@Transactional(readOnly = true)
	@Query("SELECT MAX(obj.codcontrib) FROM Tcontribuintes obj ")
			Integer findMax();
	
	/*@Transactional(readOnly = true) // Não necessita ser envolvida como transação no banco de dados, diminui o gerenciamento de loking
	Page<Tcontribuintes> findDistinctByNOMEContaining(String nome, Pageable pageRequest);*/
	
}




