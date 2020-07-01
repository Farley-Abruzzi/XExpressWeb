package com.mcexpress.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mcexpress.domain.Tfuncionarios;

//anotação para classe e transformá-la em uma interface e herança de JPAREpository do Spring
@Repository
public interface TfuncionariosRepository extends JpaRepository<Tfuncionarios, Integer>  {
	
	// ============================= Buscar mensageiro pelo id codcargo ========================
	@Transactional(readOnly = true)
	@Query(value = "select obj from Tfuncionarios obj "
			+ "where obj.SITUACAO = 'A' "
			+ "AND obj.CODCARGO = 2 "
			+ "AND obj.CODMENSAGEIROAMAIS IS NOT NULL "
			+ "AND obj.CODFUNC NOT IN (709,746,755,822,764) "
			+ "ORDER BY obj.NOME " )
	List<Tfuncionarios> buscarFuncionarios(Boolean v);
	
	//755 cofrinho 755 guilherme martins de melo
	//822 cofrinho 822 jean paulo
	//764 mensageiro teste
	
	// ============================= Buscar operador pelo id codcargo ========================
	@Transactional(readOnly = true)
	@Query(value = "select obj from Tfuncionarios obj "
			+ "where obj.SITUACAO = 'A' "
			+ "AND obj.CODCARGO = 1 "
			+ "AND obj.CODFUNC NOT IN (709,746,755,822,764) "
			+ "ORDER BY obj.NOME " )
	List<Tfuncionarios> buscarOperador(Boolean v);
	
	
	// Usuario por nome
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Tfuncionarios obj "
			+ "WHERE obj.NOME like %:nome% ") 
		Tfuncionarios findUsuarioPorNome(@Param("nome") String nome);
}






