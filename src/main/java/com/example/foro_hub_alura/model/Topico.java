package com.example.foro_hub_alura.model;

import com.example.foro_hub_alura.auth.model.Usuario;
import com.example.foro_hub_alura.dto.TopicoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table (name = "topico")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    private String titulo;
    private Boolean status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas;

    @ManyToOne //(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario autor;

    //Asigna los valores del DTO a una clase Topico
    public Topico(TopicoDTO topicoDTO){
        this.titulo = topicoDTO.titulo();
        this.mensaje = topicoDTO.mensaje();

        if(topicoDTO.autor() != null){
            this.autor = new Usuario(topicoDTO.autor());
        }

        if (topicoDTO.curso() != null) {
            this.curso = new Curso(
                    topicoDTO.curso().getId(),
                    topicoDTO.curso().getNombre(),
                    topicoDTO.curso().getCategoria()
            );
        }

        this.fechaCreacion = LocalDateTime.now();
        this.status = true;
    }
}
