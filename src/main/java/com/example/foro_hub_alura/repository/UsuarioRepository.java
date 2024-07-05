package com.example.foro_hub_alura.repository;

import com.example.foro_hub_alura.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
