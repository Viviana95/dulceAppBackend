package com.dulceapp.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulceapp.backend.entity.Receta;
import com.dulceapp.backend.repository.RecetaRepository;

@Service
public class RecetaServiceImpl implements RecetaService {

    @Autowired
    private RecetaRepository recetaRepository;

    @Override
    public List<Receta> listarRecetas() {
        return recetaRepository.findAll();
    }

    @Override
    public Receta obtenerPorId(Integer id) {
        Optional<Receta> receta = recetaRepository.findById(id);
        return receta.orElse(null);
    }

    @Override
    public Receta guardarReceta(Receta receta) {
        return recetaRepository.save(receta);
    }

    @Override
    public void eliminarReceta(Integer id) {
        recetaRepository.deleteById(id);
    }
}
