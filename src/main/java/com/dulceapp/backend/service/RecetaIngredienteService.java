package com.dulceapp.backend.service;

import java.util.List;

import com.dulceapp.backend.entity.RecetaIngrediente;

public interface RecetaIngredienteService {
	List<RecetaIngrediente> listarTodos();
    RecetaIngrediente obtenerPorId(Integer id);
    RecetaIngrediente guardar(RecetaIngrediente recetaIngrediente);
    void eliminar(Integer id);
    List<RecetaIngrediente> listarPorIdReceta(Integer idReceta);
}
