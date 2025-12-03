package com.dulceapp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dulceapp.backend.entity.Ingrediente;
import com.dulceapp.backend.service.IngredienteService;

import java.util.List;

@RestController
@RequestMapping("/api/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping
    public List<Ingrediente> listarTodos() {
        return ingredienteService.listarIngredientes();
    }

    @GetMapping("/{id}")
    public Ingrediente obtenerPorId(@PathVariable Integer id) {
        return ingredienteService.obtenerPorId(id);
    }

    @PostMapping
    public Ingrediente crearIngrediente(@RequestBody Ingrediente ingrediente) {
        return ingredienteService.guardarIngrediente(ingrediente);
    }

    @PutMapping("/{id}")
    public Ingrediente actualizarIngrediente(@PathVariable Integer id, @RequestBody Ingrediente ingrediente) {
        ingrediente.setId(id);
        return ingredienteService.guardarIngrediente(ingrediente);
    }

    @DeleteMapping("/{id}")
    public void eliminarIngrediente(@PathVariable Integer id) {
        ingredienteService.eliminarIngrediente(id);
    }
}
