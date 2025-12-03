package com.dulceapp.backend.service;

import java.util.List;

import com.dulceapp.backend.entity.Ingrediente;

public interface IngredienteService {
	List<Ingrediente> listarIngredientes();
    Ingrediente obtenerPorId(Integer id);
    Ingrediente guardarIngrediente(Ingrediente ingrediente);
    void eliminarIngrediente(Integer id);
}
