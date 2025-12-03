package com.dulceapp.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dulceapp.backend.entity.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Integer>{
	List<Favorito>findByUsuarioId(int idUsuario);
}
