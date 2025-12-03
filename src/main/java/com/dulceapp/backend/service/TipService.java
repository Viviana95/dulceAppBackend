package com.dulceapp.backend.service;

import java.util.List;

import com.dulceapp.backend.entity.Tip;

public interface TipService {
	List<Tip> listarTodos();
    Tip obtenerPorId(Integer id);
    Tip guardar(Tip tip);
    void eliminar(Integer id);
}
