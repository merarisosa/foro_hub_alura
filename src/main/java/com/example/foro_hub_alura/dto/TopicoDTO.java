package com.example.foro_hub_alura.dto;

import com.example.foro_hub_alura.auth.dto.UsuarioDTO;
import com.example.foro_hub_alura.model.Curso;
import com.example.foro_hub_alura.model.Topico;

public record TopicoDTO(
        String titulo,
        String mensaje,
        UsuarioDTO autor,
        Curso curso
) {

    public TopicoDTO(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                new UsuarioDTO(topico.getAutor()),
                topico.getCurso()
        );
    }
}
