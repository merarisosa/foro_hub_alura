package com.example.foro_hub_alura.auth.controller;

import com.example.foro_hub_alura.auth.model.Usuario;
import com.example.foro_hub_alura.auth.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UsuarioController {
    private final UsuarioService userService;

    public UsuarioController(UsuarioService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<Usuario> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Usuario currentUser = (Usuario) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> allUsers() {
        List <Usuario> users = userService.allUsers();

        return ResponseEntity.ok(users);
    }
}