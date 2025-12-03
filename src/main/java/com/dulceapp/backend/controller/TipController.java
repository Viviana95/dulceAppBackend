package com.dulceapp.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dulceapp.backend.entity.Tip;
import com.dulceapp.backend.service.TipService;

import java.util.List;

@RestController
@RequestMapping("/api/tips")
public class TipController {

    @Autowired
    private TipService tipService;

    @GetMapping
    public List<Tip> listarTodos() {
        return tipService.listarTodos();
    }

    @GetMapping("/{id}")
    public Tip obtenerPorId(@PathVariable Integer id) {
        return tipService.obtenerPorId(id);
    }

    @PostMapping
    public Tip crearTip(@RequestBody Tip tip) {
        return tipService.guardar(tip);
    }

    @PutMapping("/{id}")
    public Tip actualizarTip(@PathVariable Integer id, @RequestBody Tip tip) {
        tip.setId(id);
        return tipService.guardar(tip);
    }

    @DeleteMapping("/{id}")
    public void eliminarTip(@PathVariable Integer id) {
        tipService.eliminar(id);
    }
}
