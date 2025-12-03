package com.dulceapp.backend.service;

import java.util.List;

import com.dulceapp.backend.entity.Receta;

public interface RecetaService {
	List<Receta> listarRecetas();
    Receta obtenerPorId(Integer id);
    Receta guardarReceta(Receta receta);
    void eliminarReceta(Integer id);
}
