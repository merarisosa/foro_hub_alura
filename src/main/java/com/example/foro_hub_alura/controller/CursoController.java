package com.example.foro_hub_alura.controller;

import com.example.foro_hub_alura.dto.CursoDTO;
import com.example.foro_hub_alura.model.Curso;
import com.example.foro_hub_alura.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoDTO> registrarCurso(@RequestBody @Valid CursoDTO cursoDTO){
        cursoService.registrarCurso(cursoDTO);

        return ResponseEntity.ok(cursoDTO);
    }
}
