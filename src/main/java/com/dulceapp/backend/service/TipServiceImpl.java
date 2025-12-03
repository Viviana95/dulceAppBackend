package com.dulceapp.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulceapp.backend.entity.Tip;
import com.dulceapp.backend.repository.TipRepository;

@Service
public class TipServiceImpl implements TipService {

    @Autowired
    private TipRepository tipRepository;

    @Override
    public List<Tip> listarTodos() {
        return tipRepository.findAll();
    }

    @Override
    public Tip obtenerPorId(Integer id) {
        Optional<Tip> tip = tipRepository.findById(id);
        return tip.orElse(null);
    }

    @Override
    public Tip guardar(Tip tip) {
        return tipRepository.save(tip);
    }

    @Override
    public void eliminar(Integer id) {
        tipRepository.deleteById(id);
    }
}
