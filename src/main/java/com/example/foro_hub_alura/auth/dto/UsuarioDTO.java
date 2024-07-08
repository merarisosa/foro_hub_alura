package com.example.foro_hub_alura.auth.dto;

import com.example.foro_hub_alura.auth.model.Usuario;

public record UsuarioDTO(
        String nombre,
        String correo,
        String contrasena
) {

    public UsuarioDTO(Usuario usuario){
        this(usuario.getNombre(), usuario.getCorreo(), usuario.getContrasena());
    }
}
