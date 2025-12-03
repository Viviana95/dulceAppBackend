package com.dulceapp.backend.service;

import java.util.List;

import com.dulceapp.backend.entity.Categoria;

public interface CategoriaService {
	List<Categoria> listarCategorias();
    Categoria obtenerPorId(Integer id);
    Categoria guardarCategoria(Categoria categoria);
    void eliminarCategoria(Integer id);
}
