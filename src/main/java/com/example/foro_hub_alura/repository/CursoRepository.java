package com.example.foro_hub_alura.repository;

import com.example.foro_hub_alura.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
