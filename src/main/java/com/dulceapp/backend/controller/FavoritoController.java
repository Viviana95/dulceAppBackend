package com.dulceapp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dulceapp.backend.entity.Favorito;
import com.dulceapp.backend.service.FavoritoService;

import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;

    @GetMapping
    public List<Favorito> listarTodos() {
        return favoritoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Favorito obtenerPorId(@PathVariable Integer id) {
        return favoritoService.obtenerPorId(id);
    }
    
    @GetMapping("/usuario/{id}")
    public List<Favorito> obtenerPorUsuario(@PathVariable Integer id) {
        return favoritoService.listarPorUsuario(id);
    }

    @PostMapping
    public Favorito crearFavorito(@RequestBody Favorito favorito) {
        return favoritoService.guardar(favorito);
    }

    @PutMapping("/{id}")
    public Favorito actualizarFavorito(@PathVariable Integer id, @RequestBody Favorito favorito) {
        favorito.setId(id);
        return favoritoService.guardar(favorito);
    }

    @DeleteMapping("/{id}")
    public void eliminarFavorito(@PathVariable Integer id) {
        favoritoService.eliminar(id);
    }
}
