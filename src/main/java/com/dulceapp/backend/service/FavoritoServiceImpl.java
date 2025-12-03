package com.dulceapp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulceapp.backend.entity.Favorito;
import com.dulceapp.backend.repository.FavoritoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritoServiceImpl implements FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    @Override
    public List<Favorito> listarTodos() {
        return favoritoRepository.findAll();
    }

    @Override
    public Favorito obtenerPorId(Integer id) {
        Optional<Favorito> favorito = favoritoRepository.findById(id);
        return favorito.orElse(null);
    }

    @Override
    public Favorito guardar(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    @Override
    public void eliminar(Integer id) {
        favoritoRepository.deleteById(id);
    }

	@Override
	public List<Favorito> listarPorUsuario(Integer idUsuario) {
		
		return favoritoRepository.findByUsuarioId(idUsuario) ;
	}
}
