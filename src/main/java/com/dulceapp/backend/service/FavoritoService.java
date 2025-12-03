package com.dulceapp.backend.service;

import java.util.List;

import com.dulceapp.backend.entity.Favorito;

public interface FavoritoService {
	List<Favorito> listarTodos();
    Favorito obtenerPorId(Integer id);
    Favorito guardar(Favorito favorito);
    void eliminar(Integer id);
    List<Favorito> listarPorUsuario(Integer id);
}
