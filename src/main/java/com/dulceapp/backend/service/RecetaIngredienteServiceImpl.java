package com.dulceapp.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulceapp.backend.entity.RecetaIngrediente;
import com.dulceapp.backend.repository.RecetaIngredienteRepository;

@Service
public class RecetaIngredienteServiceImpl implements RecetaIngredienteService {

    @Autowired
    private RecetaIngredienteRepository recetaIngredienteRepository;

    @Override
    public List<RecetaIngrediente> listarTodos() {
        return recetaIngredienteRepository.findAll();
    }

    @Override
    public RecetaIngrediente obtenerPorId(Integer id) {
        Optional<RecetaIngrediente> ri = recetaIngredienteRepository.findById(id);
        return ri.orElse(null);
    }

    @Override
    public RecetaIngrediente guardar(RecetaIngrediente recetaIngrediente) {
        return recetaIngredienteRepository.save(recetaIngrediente);
    }

    @Override
    public void eliminar(Integer id) {
        recetaIngredienteRepository.deleteById(id);
    }

	@Override
	public List<RecetaIngrediente> listarPorIdReceta(Integer idReceta) {
		return recetaIngredienteRepository.findByRecetaId(idReceta);
	}
}
