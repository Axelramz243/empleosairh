package com.axel.huerta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axel.huerta.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {
	

}
