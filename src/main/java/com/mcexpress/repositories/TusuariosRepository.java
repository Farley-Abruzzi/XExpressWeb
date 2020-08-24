package com.mcexpress.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcexpress.domain.Tusuarios;

public interface TusuariosRepository extends JpaRepository<Tusuarios, Integer> {
	
	@Query("SELECT MAX(obj.CODUSUARIO) FROM Tusuarios obj ")
	Integer findMax();
}
