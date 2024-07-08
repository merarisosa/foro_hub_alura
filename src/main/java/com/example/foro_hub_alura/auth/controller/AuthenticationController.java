package com.example.foro_hub_alura.auth.controller;

import com.example.foro_hub_alura.auth.dto.LoginResponseDTO;
import com.example.foro_hub_alura.auth.dto.LoginUserDto;
import com.example.foro_hub_alura.auth.dto.RegisterUserDTO;
import com.example.foro_hub_alura.auth.model.LoginResponse;
import com.example.foro_hub_alura.auth.model.Usuario;
import com.example.foro_hub_alura.auth.service.AuthenticationService;
import com.example.foro_hub_alura.auth.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> register(@RequestBody RegisterUserDTO registerUserDto) {
        Usuario registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody LoginUserDto loginUserDto) {
        Usuario authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse(
                jwtToken,
                jwtService.getExpirationTime()
        );

        return ResponseEntity.ok(new LoginResponseDTO(loginResponse));
    }
}