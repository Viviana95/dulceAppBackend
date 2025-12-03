package com.dulceapp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dulceapp.backend.entity.RecetaIngrediente;
import com.dulceapp.backend.service.RecetaIngredienteService;

import java.util.List;

@RestController
@RequestMapping("/api/receta-ingredientes")
public class RecetaIngredienteController {

    @Autowired
    private RecetaIngredienteService recetaIngredienteService;

    @GetMapping
    public List<RecetaIngrediente> listarTodos() {
        return recetaIngredienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public RecetaIngrediente obtenerPorId(@PathVariable Integer id) {
        return recetaIngredienteService.obtenerPorId(id);
    }

    @PostMapping
    public RecetaIngrediente crear(@RequestBody RecetaIngrediente recetaIngrediente) {
        return recetaIngredienteService.guardar(recetaIngrediente);
    }

    @PutMapping("/{id}")
    public RecetaIngrediente actualizar(@PathVariable Integer id, @RequestBody RecetaIngrediente recetaIngrediente) {
        recetaIngrediente.setId(id);
        return recetaIngredienteService.guardar(recetaIngrediente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        recetaIngredienteService.eliminar(id);
    }
    @GetMapping("/receta/{id}")
    public List<RecetaIngrediente> obtenerPorRecetaId(@PathVariable Integer id) {
        return recetaIngredienteService.listarPorIdReceta(id);
    }
}
