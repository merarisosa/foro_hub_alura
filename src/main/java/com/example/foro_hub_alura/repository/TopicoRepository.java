package com.example.foro_hub_alura.repository;

import com.example.foro_hub_alura.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> findTop10ByOrderByFechaCreacionAsc();

    // Método personalizado para encontrar tópicos por nombre y año de creación usando consulta nativa
    @Query(value =
            "SELECT * FROM topico t WHERE t.titulo = :titulo AND EXTRACT(YEAR FROM t.fecha_creacion) = :year", nativeQuery = true)
    List<Topico> findByTituloAndYear(@Param("titulo") String titulo, @Param("year") int year);

}
