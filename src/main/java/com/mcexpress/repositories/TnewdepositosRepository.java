package com.mcexpress.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mcexpress.domain.Tnewdepositos;


@Repository
public interface TnewdepositosRepository extends JpaRepository<Tnewdepositos, Integer>  {
	
//	@Query("SELECT obj FROM Tnewdepositos obj "
//			+ "WHERE obj.codmensageiro =:cod ")
//			Optional<Tnewdepositos> findId(
//			@Param("cod") Integer cod);
	
	//=================================Depositos código máximo de incremento no BD Firebird=============
	@Transactional(readOnly = true)
	@Query("SELECT MAX(obj.NRODEPOSITO) FROM Tnewdepositos obj ")
				Integer findMax();
	
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Tnewdepositos obj "
			+ "WHERE obj.CODMENSAGEIRO =:cod ")
			Tnewdepositos findId(
			@Param("cod") Integer cod);

	Tnewdepositos findByEmail(String username);

	
}
