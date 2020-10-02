package com.mcexpress.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mcexpress.domain.Tnewdepositos;

@Repository
public interface TnewdepositosRepository extends JpaRepository<Tnewdepositos, Integer>  {
	
	/*@Query("SELECT obj FROM Tnewdepositos obj "
			+ "WHERE obj.nrodeposito =:cod ")
			Optional<Tnewdepositos> findId(
			@Param("cod") Integer cod);*/
	
	//=================================Depositos código máximo de incremento no BD Firebird=============
	@Transactional(readOnly = true)
	@Query("SELECT MAX(obj.NRODEPOSITO) FROM Tnewdepositos obj ")
				Integer findMax();
	
	@Transactional(readOnly = true)
	Tnewdepositos findOne(Integer id);
		
}
