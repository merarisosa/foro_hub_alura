package com.example.foro_hub_alura.service;

import com.example.foro_hub_alura.dto.TopicoDTO;
import com.example.foro_hub_alura.model.Topico;
import com.example.foro_hub_alura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    public void registrarTopico(TopicoDTO topicoDTO) {
        Topico topico = new Topico(topicoDTO);
        topicoRepository.save(topico);
        System.out.println("Nuevo tópico creado: " + topico);
    }
}
