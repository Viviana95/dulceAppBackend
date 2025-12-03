package com.dulceapp.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulceapp.backend.entity.Ingrediente;
import com.dulceapp.backend.repository.IngredienteRepository;

@Service
public class IngredienteServiceImpl implements IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public List<Ingrediente> listarIngredientes() {
        return ingredienteRepository.findAll();
    }

    @Override
    public Ingrediente obtenerPorId(Integer id) {
        Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
        return ingrediente.orElse(null);
    }

    @Override
    public Ingrediente guardarIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    @Override
    public void eliminarIngrediente(Integer id) {
        ingredienteRepository.deleteById(id);
    }
}
