package com.example.foro_hub_alura.dto;

import com.example.foro_hub_alura.model.Topico;
import com.example.foro_hub_alura.auth.model.Usuario;

import java.time.LocalDateTime;

public record RespuestaDTO(
        Long id,
        String mensaje,
        String solucion,
        LocalDateTime fechaCreacion,
        Usuario autor,
        Topico topico
) {
}
