package com.example.foro_hub_alura.dto;

import com.example.foro_hub_alura.auth.model.Usuario;

public record UsuarioAutorDTO(
        String nombre
        ) {

    public UsuarioAutorDTO(Usuario usuario){
        this(usuario.getNombre());
    }
}
