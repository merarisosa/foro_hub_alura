package com.example.foro_hub_alura.model;

import com.example.foro_hub_alura.model.abstracts.DatosGenerales;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "perfil")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

}
