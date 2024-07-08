package com.example.foro_hub_alura.auth.service;

import com.example.foro_hub_alura.auth.dto.LoginUserDto;
import com.example.foro_hub_alura.auth.dto.RegisterUserDTO;
import com.example.foro_hub_alura.auth.model.Usuario;
import com.example.foro_hub_alura.auth.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UsuarioRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario signup(RegisterUserDTO input) {
        String encodedPassword = passwordEncoder.encode(input.password());
        Usuario user = new Usuario(
                input.fullName(),
                input.email(),
                encodedPassword);

        return usuarioRepository.save(user);
    }

    public Usuario authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.password()
                )
        );

        return usuarioRepository.findByCorreo(input.email())
                .orElseThrow();
    }
}
