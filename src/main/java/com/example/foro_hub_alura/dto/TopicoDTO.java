package com.example.foro_hub_alura.dto;

import com.example.foro_hub_alura.model.Curso;
import com.example.foro_hub_alura.model.Topico;

import java.time.LocalDateTime;

public record TopicoDTO(
        String titulo,
        String mensaje,
        UsuarioAutorDTO autor,
        Curso curso,
        LocalDateTime fechaCreacion,
        Boolean status
) {

    public TopicoDTO(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                new UsuarioAutorDTO(topico.getAutor()),
                topico.getCurso(),
                topico.getFechaCreacion(),
                topico.getStatus()
        );
    }
}
