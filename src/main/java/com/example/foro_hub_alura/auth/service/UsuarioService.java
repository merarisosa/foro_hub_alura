package com.example.foro_hub_alura.auth.service;

import com.example.foro_hub_alura.auth.model.Usuario;
import com.example.foro_hub_alura.auth.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository userRepository;

    public UsuarioService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Usuario> allUsers() {
        List<Usuario> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return users;
    }
}
