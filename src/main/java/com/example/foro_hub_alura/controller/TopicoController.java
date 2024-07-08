package com.example.foro_hub_alura.controller;

import com.example.foro_hub_alura.dto.TopicoDTO;
import com.example.foro_hub_alura.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoService topicoService;

    @PostMapping
    public ResponseEntity<TopicoDTO> registrarTopico(@RequestBody @Valid TopicoDTO topicoDTO){
        topicoService.registrarTopico(topicoDTO);

        return ResponseEntity.ok(topicoDTO);
    }
}
