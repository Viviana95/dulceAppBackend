package com.dulceapp.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dulceapp.backend.entity.RecetaIngrediente;

public interface RecetaIngredienteRepository extends JpaRepository<RecetaIngrediente, Integer>{
	List<RecetaIngrediente> findByRecetaId(Integer idReceta);
}
