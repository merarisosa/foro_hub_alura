package com.example.foro_hub_alura.auth.dto;

import com.example.foro_hub_alura.auth.model.LoginResponse;

public record LoginResponseDTO(
     String token,
     Long expiresIn
) {
   public LoginResponseDTO(LoginResponse loginResponse){
       this(loginResponse.getToken(), loginResponse.getExpiresIn());
   }
}

