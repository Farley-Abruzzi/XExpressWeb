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

import com.mcexpress.domain.Thistoricorecibo;
//anotação para classe e transformá-la em uma interface e herança de JPAREpository do Spring
@Repository
public interface ThistoricoReciboRepository extends JpaRepository<Thistoricorecibo, Integer>  {
	
	//=================================Feriado por id=============
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Thistoricorecibo obj "
			+ "WHERE obj.nrorecibo =:cod ")
			Optional<Thistoricorecibo> findId(
			@Param("cod") Integer cod);
	
	//=================================Feriado código máximo de incremento no BD Firebird=============
	@Transactional(readOnly = true)
	@Query("SELECT MAX(obj.nrorecibo) FROM Thistoricorecibo obj ")
			Integer findMax();
		
	//=================================Feriado com Paginação======
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Thistoricorecibo obj "
			+ "WHERE obj.nrorecibo =:cod ")
			Page<Thistoricorecibo> findIdPage(
			@Param("cod") Integer cod, Pageable pageRequest);
	
	//==================================Feriado com Lista=========
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Thistoricorecibo obj "
			+ "ORDER BY obj.nrorecibo ")
		List<Thistoricorecibo> findIdList();
	
}






