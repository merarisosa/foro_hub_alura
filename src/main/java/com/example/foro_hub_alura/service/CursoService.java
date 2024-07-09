package com.example.foro_hub_alura.service;

import com.example.foro_hub_alura.dto.CursoDTO;
import com.example.foro_hub_alura.model.Curso;
import com.example.foro_hub_alura.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public void registrarCurso(CursoDTO cursoDTO) {
//        Curso nombreCursoExist = cursoRepository.findByNombre(cursoDTO.nombre())
//                .orElse(cursoRepository.save(new Curso(cursoDTO)));
        // Verificar si el curso ya existe por nombre
        boolean cursoExistente = cursoRepository.findByNombre(cursoDTO.nombre()).isPresent();

        if (cursoExistente) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El curso ya existe");
        } else {
            Curso nuevoCurso = new Curso(cursoDTO);
            cursoRepository.save(nuevoCurso);
        }
    }
}
