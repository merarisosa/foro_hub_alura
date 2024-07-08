package com.example.foro_hub_alura.dto;

import com.example.foro_hub_alura.enums.Categoria;
import com.example.foro_hub_alura.model.Curso;

public record CursoDTO(
        String nombre,
        Categoria categoria
) {

    CursoDTO(Curso curso) {
        this(  curso.getNombre(),
                curso.getCategoria());
    }

}
