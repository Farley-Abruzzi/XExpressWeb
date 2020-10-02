package com.mcexpress.repositories;

import org.springframework.transaction.annotation.Transactional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcexpress.domain.Tusuarios;

@Repository
public interface TusuariosRepository extends JpaRepository<Tusuarios, Integer> {
	
	// ========================================Usuario por ID
	//Optional<Tusuarios> findById(Integer id);
	
	@Transactional(readOnly = true)
	@Query("SELECT MAX(obj.CODUSUARIO) FROM Tusuarios obj ")
	Integer findMax();
	
	@Transactional(readOnly=true)
	Tusuarios findByEmail(String email);
	
	@Transactional(readOnly=true)
	Tusuarios findByLogin(String login);
	
	@Transactional(readOnly=true)
	Tusuarios findOne(Integer id);

}
