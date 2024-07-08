package com.example.foro_hub_alura.model;

import com.example.foro_hub_alura.dto.CursoDTO;
import com.example.foro_hub_alura.enums.Categoria;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "curso")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(CursoDTO cursoDTO){
        this.nombre = cursoDTO.nombre();
        this.categoria = cursoDTO.categoria();
    }

}
