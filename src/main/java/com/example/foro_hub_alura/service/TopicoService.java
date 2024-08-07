package com.example.foro_hub_alura.service;

import com.example.foro_hub_alura.auth.model.Usuario;
import com.example.foro_hub_alura.auth.repository.UsuarioRepository;
import com.example.foro_hub_alura.dto.TopicoDTO;
import com.example.foro_hub_alura.dto.UsuarioAutorDTO;
import com.example.foro_hub_alura.model.Curso;
import com.example.foro_hub_alura.model.Topico;
import com.example.foro_hub_alura.repository.CursoRepository;
import com.example.foro_hub_alura.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CursoRepository cursoRepository;

    public void registrarTopico(TopicoDTO topicoDTO) {
        //verificar el usuario que envio la solicitud
        Usuario usuarioExist = usuarioRepository.findByNombre(topicoDTO.autor().nombre())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario no registrado"));

        //verificar el curso en la plataforma
        Curso cursoExist = cursoRepository.findByNombre(topicoDTO.curso().getNombre())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Curso no registrado"));

        //guadar el topico en la plataforma
        // crear y guardar el topico en la plataforma con referencias a entidades existentes
        Topico topico = new Topico(topicoDTO);
        topico.setAutor(usuarioExist);
        topico.setCurso(cursoExist);
        topicoRepository.save(topico);

        System.out.println("Nuevo tópico creado: " + topico);
    }

    //Metodo que obtiene TODOS los topicos
    public List<TopicoDTO> obtenerTopicos(){
        List<Topico> topicos = topicoRepository.findAll();
        return convierteClassToRecord(topicos);
    }

    //Metodo que obtiene los 10 topicos mas recientes
    public List<TopicoDTO> obtener10topicos(){
        List<Topico> topicos = topicoRepository.findTop10ByOrderByFechaCreacionAsc();
        return convierteClassToRecord(topicos);
    }

    //Metodo que obtiene los topicos por nombre y año
    public List<TopicoDTO> obtenerTopicoByNombreAndYear(String titulo, int year){
        List<Topico> topicos = topicoRepository.findByTituloAndYear(titulo, year);
        return convierteClassToRecord(topicos);    }

    //Metodo que convierte la data de Clase a Record
    public List<TopicoDTO> convierteClassToRecord(List<Topico> topicos){
         return topicos.stream()
                .map(TopicoDTO::new)
                .toList();
    }

    //Metodo para obtener los topicos paginables
    public Page<TopicoDTO> obtenerTopicosInPages(Pageable pageable) {
        Page<Topico> topicos = topicoRepository.findAll(pageable);
        return topicos.map(TopicoDTO::new);
    }

    //Metodo para obtener los topicos por id
    public TopicoDTO obtenerTopicoById(Long id){
        Optional<Topico> topicoId = topicoRepository.findById(id);
        return new TopicoDTO(topicoId.get());
    }

    //Metodo para editar un topico por id
    public TopicoDTO editarTopicoById(Long id, TopicoDTO topicoDTO) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Topico no existente"));

        if (topicoDTO.titulo() != null) {
            topico.setTitulo(topicoDTO.titulo());
        }
        if (topicoDTO.mensaje() != null) {
            topico.setMensaje(topicoDTO.mensaje());
        }
        if (topicoDTO.curso() != null) {
            topico.setCurso(topicoDTO.curso());
        }
        if(topicoDTO.autor() != null){
            if (topico.getAutor().getId() == topicoDTO.autor().id()) {
                topico.setAutor(new Usuario(topicoDTO.autor()));
            }
        }
        Topico topicoActualizado = topicoRepository.save(topico);
        return new TopicoDTO(topicoActualizado);
    }

    public void deleteId(Long id){
        if(topicoRepository.findById(id).isPresent()){
            topicoRepository.deleteById(id);
            System.out.println("Topico eliminado");
        } else{
            System.out.println("El topico no existe");
        }
    }
}
