package com.example.foro_hub_alura.auth.dto;

public record RegisterUserDTO(
        String email,
         String password,
         String fullName
) {
}
