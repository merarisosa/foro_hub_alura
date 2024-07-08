package com.example.foro_hub_alura.repository;

import com.example.foro_hub_alura.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
}
