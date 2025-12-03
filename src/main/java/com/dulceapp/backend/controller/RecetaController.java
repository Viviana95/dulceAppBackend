package com.dulceapp.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dulceapp.backend.entity.Receta;
import com.dulceapp.backend.service.RecetaService;

@RestController
@RequestMapping("/api/recetas")
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

    @GetMapping
    public List<Receta> listarTodas() {
        return recetaService.listarRecetas();
    }

    @GetMapping("/{id}")
    public Receta obtenerPorId(@PathVariable Integer id) {
        return recetaService.obtenerPorId(id);
    }

    @PostMapping
    public Receta crearReceta(@RequestBody Receta receta) {
        return recetaService.guardarReceta(receta);
    }

    @PutMapping("/{id}")
    public Receta actualizarReceta(@PathVariable Integer id, @RequestBody Receta receta) {
        receta.setId(id);
        return recetaService.guardarReceta(receta);
    }

    @DeleteMapping("/{id}")
    public void eliminarReceta(@PathVariable Integer id) {
        recetaService.eliminarReceta(id);
    }
}
