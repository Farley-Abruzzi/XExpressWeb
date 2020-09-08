package com.mcexpress.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mcexpress.domain.Tferiado;
//anotação para classe e transformá-la em uma interface e herança de JPAREpository do Spring
@Repository
public interface TferiadoRepository extends JpaRepository<Tferiado, Integer>  {
	
	//=================================Feriado por id=============
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Tferiado obj "
			+ "WHERE obj.CODFERIADO =:cod ")
			Optional<Tferiado> findId(
			@Param("cod") Integer cod);
	
	//=================================Feriado código máximo de incremento no BD Firebird=============
	@Transactional(readOnly = true)
	@Query("SELECT MAX(obj.CODFERIADO) FROM Tferiado obj ")
			Integer findMax();
		
	//=================================Feriado com Paginação======
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Tferiado obj "
			+ "WHERE obj.CODFERIADO =:cod ")
			Page<Tferiado> findIdPage(
			@Param("cod") Integer cod, Pageable pageRequest);
	
	//==================================Feriado com Lista=========
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Tferiado obj "
			+ "ORDER BY obj.CODFERIADO ")
		List<Tferiado> findIdList();
	
}






