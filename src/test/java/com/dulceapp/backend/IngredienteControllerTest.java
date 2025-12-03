package com.dulceapp.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dulceapp.backend.controller.IngredienteController;
import com.dulceapp.backend.entity.Ingrediente;
import com.dulceapp.backend.service.IngredienteService;

public class IngredienteControllerTest {
	@Mock 
	private IngredienteService ingredienteService;
    @InjectMocks 
    private IngredienteController ingredienteController;
    
    private Ingrediente ingrediente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ingrediente = new Ingrediente();
        ingrediente.setId(1);
        ingrediente.setNombre("Harina");
    }
    
    @Test
    void crearIngrediente() {
        when(ingredienteService.guardarIngrediente(ingrediente)).thenReturn(ingrediente);
        
        Ingrediente resultado = ingredienteController.crearIngrediente(ingrediente);
        
        assertEquals(1, resultado.getId());
        assertEquals("Harina", resultado.getNombre());
    }

    @Test
    void actualizarIngrediente() {
    	Ingrediente ingredienteAct = new Ingrediente();
         ingredienteAct.setId(1);
         ingredienteAct.setNombre("HarinaTestt");
        when(ingredienteService.guardarIngrediente(ingredienteAct)).thenReturn(ingredienteAct);
        
        Ingrediente resultado = ingredienteController.actualizarIngrediente(1, ingredienteAct);
        
        assertEquals(1, resultado.getId());
        assertEquals("HarinaTestt", resultado.getNombre());
    }

    @Test void listarTodos() {
        when(ingredienteService.listarIngredientes()).thenReturn(Arrays.asList(ingrediente));
        List<Ingrediente> resultado = ingredienteController.listarTodos();
        assertEquals(1, resultado.size());
    }

    @Test void obtenerPorId() {
        when(ingredienteService.obtenerPorId(1)).thenReturn(ingrediente);
        Ingrediente resultado = ingredienteController.obtenerPorId(1);
        assertEquals("Harina", resultado.getNombre());
    }
}
