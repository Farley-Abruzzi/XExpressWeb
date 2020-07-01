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

import com.mcexpress.domain.Trecdevolvidosweb;
//anotação para classe e transformá-la em uma interface e herança de JPAREpository do Spring
@Repository
public interface TrecdevolvidoswebRepository extends JpaRepository<Trecdevolvidosweb, Integer>  {
	
	//=================================Feriado por id=============
	@Query("SELECT obj FROM Trecdevolvidosweb obj "
			+ "WHERE obj.nrorecibo =:cod ")
			Optional<Trecdevolvidosweb> findId(
			@Param("cod") Integer cod);
	
	//=================================Feriado código máximo de incremento no BD Firebird=============
	@Query("SELECT MAX(obj.nrorecibo) FROM Trecdevolvidosweb obj ")
			Integer findMax();
		
	//=================================Feriado com Paginação======
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Trecdevolvidosweb obj "
			+ "WHERE obj.nrorecibo =:cod ")
			Page<Trecdevolvidosweb> findIdPage(
			@Param("cod") Integer cod, Pageable pageRequest);
	
	//==================================Feriado com Lista=========
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Trecdevolvidosweb obj "
			+ "ORDER BY obj.nrorecibo ")
		List<Trecdevolvidosweb> findIdList();
	
}






