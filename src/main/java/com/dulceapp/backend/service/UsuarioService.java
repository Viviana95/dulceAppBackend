package com.dulceapp.backend.service;

import java.util.List;

import com.dulceapp.backend.entity.Usuario;

public interface UsuarioService {
	List<Usuario> listarUsuarios();
    Usuario obtenerPorId(Integer id);
    Usuario guardarUsuario(Usuario usuario);
    void eliminarUsuario(Integer id);
    Usuario obtenerPorEmail(String email);

}
