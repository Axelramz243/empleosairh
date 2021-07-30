package com.axel.huerta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axel.huerta.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {
	
	List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(int destacado,String estatus);
	
}
