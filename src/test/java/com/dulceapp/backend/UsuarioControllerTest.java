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
import com.dulceapp.backend.controller.UsuarioController;
import com.dulceapp.backend.entity.Usuario;
import com.dulceapp.backend.service.UsuarioService;

public class UsuarioControllerTest {
	
	@Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    private Usuario usuarioTest;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); 
       usuarioTest = new Usuario(1, "Jesus", "jesus@test.com", "123", Usuario.Rol.usuario);

    }

    @Test
    void listarTodos() {
        List<Usuario> usuariosMock = Arrays.asList(usuarioTest);
        when(usuarioService.listarUsuarios()).thenReturn(usuariosMock);

        List<Usuario> resultado = usuarioController.listarTodos();

        assertEquals(1, resultado.size());
        assertEquals("jesus@test.com", resultado.get(0).getEmail());
    }

    @Test
    void obtenerPorId() {
        when(usuarioService.obtenerPorId(1)).thenReturn(usuarioTest);

        Usuario resultado = usuarioController.obtenerPorId(1);

        assertEquals(1, resultado.getId());
        assertEquals("Jesus", resultado.getNombre());
    }

    @Test
    void crearUsuario() {
        when(usuarioService.guardarUsuario(usuarioTest)).thenReturn(usuarioTest);

        Usuario resultado = usuarioController.crearUsuario(usuarioTest);

        assertEquals("jesus@test.com", resultado.getEmail());
    }

    @Test
    void actualizarUsuario() {
        when(usuarioService.guardarUsuario(usuarioTest)).thenReturn(usuarioTest);

        Usuario resultado = usuarioController.actualizarUsuario(1, usuarioTest);

        assertEquals(1, resultado.getId());
    }
}
