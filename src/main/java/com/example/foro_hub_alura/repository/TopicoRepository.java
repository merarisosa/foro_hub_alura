package com.example.foro_hub_alura.repository;

import com.example.foro_hub_alura.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
