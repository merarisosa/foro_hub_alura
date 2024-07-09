package com.example.foro_hub_alura.controller;

import com.example.foro_hub_alura.dto.TopicoDTO;
import com.example.foro_hub_alura.model.Topico;
import com.example.foro_hub_alura.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDTO> registrarTopico(@RequestBody @Valid TopicoDTO topicoDTO){
        topicoService.registrarTopico(topicoDTO);

        return ResponseEntity.ok(topicoDTO);
    }

    @GetMapping
    @Transactional
    public List<TopicoDTO> obtenerTopicos(){
        return topicoService.obtenerTopicos();

    }

    @GetMapping("/top10")
    @Transactional
    public List<TopicoDTO> obtener10topicos(){
        return topicoService.obtener10topicos();
    }

    @GetMapping("/findByTitleYear")
    @Transactional
    public List<TopicoDTO> obtenerTopicoByNombreAndYear(@RequestParam String titulo, @RequestParam int year){
        return topicoService.obtenerTopicoByNombreAndYear(titulo, year);
    }

    @GetMapping("/pages")
    @Transactional
    public Page<TopicoDTO> obtenerTopicosInPages(Pageable pageable){
        return topicoService.obtenerTopicosInPages(pageable);
    }

    @GetMapping("/{id}")
    @Transactional
    public TopicoDTO obtenerTopicoById(@PathVariable @Valid Long id){
        return topicoService.obtenerTopicoById(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> editarTopicoById(@PathVariable @Valid Long id, @RequestBody TopicoDTO topicoDTO){
        //topicoService.editarTopicoById(id, topicoDTO);

        return ResponseEntity.ok(topicoService.editarTopicoById(id, topicoDTO));
        /*
         return ResponseEntity.ok(new TopicoDTO(topicoActualizado));
        } else {
            return ResponseEntity.notFound().build();
            * */
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteId(@PathVariable @Valid Long id) {
        topicoService.deleteId(id);
    }
}
