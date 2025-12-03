package com.dulceapp.backend;

import com.dulceapp.backend.controller.RecetaController;
import com.dulceapp.backend.entity.Categoria;
import com.dulceapp.backend.entity.Receta;
import com.dulceapp.backend.entity.Usuario;
import com.dulceapp.backend.service.RecetaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RecetaControllerTest {
	
	@Mock 
	private RecetaService recetaService;
	
    @InjectMocks 
    private RecetaController recetaController;
    
    private Receta recetaTest;
 // Crear Usuario mock
    Usuario usuario = new Usuario(1, "Test","test@test.com", "admin", Usuario.Rol.usuario);
   
    // Crear Categoria mock
    Categoria categoria = new Categoria(1, "Tartas");
   
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recetaTest = new Receta(); 
        recetaTest.setId(1);
        recetaTest.setTitulo("Tarta de Chocolate");
        recetaTest.setDescripcion("Deliciosa tarta casera");
        recetaTest.setInstrucciones("Mezclar todo y hornear");
        recetaTest.setTiempoPreparacion(30);
        recetaTest.setTiempoCoccion(45);
        recetaTest.setUsuario(usuario);
        recetaTest.setCategoria(categoria);    
        recetaTest.setActiva(true);
    }
    
    @Test 
    void crearReceta() {
        when(recetaService.guardarReceta(recetaTest)).thenReturn(recetaTest);
        Receta resultado = recetaController.crearReceta(recetaTest);
        assertEquals("Tarta de Chocolate", resultado.getTitulo());
    }

    @Test 
    void listarTodas() {
        when(recetaService.listarRecetas()).thenReturn(Arrays.asList(recetaTest));
        List<Receta> resultado = recetaController.listarTodas();
        assertEquals(1, resultado.size());
        assertEquals("Tarta de Chocolate", resultado.get(0).getTitulo());
    }

    @Test 
    void obtenerPorId() {
        when(recetaService.obtenerPorId(1)).thenReturn(recetaTest);
        Receta resultado = recetaController.obtenerPorId(1);
        assertEquals(1, resultado.getId());
    }

   
}