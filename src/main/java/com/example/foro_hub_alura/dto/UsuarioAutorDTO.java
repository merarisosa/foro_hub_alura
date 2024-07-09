package com.example.foro_hub_alura.dto;

import com.example.foro_hub_alura.auth.model.Usuario;

public record UsuarioAutorDTO(
        Long id,
        String nombre
        ) {

    public UsuarioAutorDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNombre());
    }
}
