package com.example.foro_hub_alura.auth.model;

import com.example.foro_hub_alura.auth.dto.RegisterUserDTO;
import com.example.foro_hub_alura.auth.dto.UsuarioDTO;
import com.example.foro_hub_alura.dto.UsuarioAutorDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Table(name = "usuario")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Email
    @Column(name = "email", unique = true, length = 100, nullable = false)
    private String correo;

    @Column(nullable = false)
    private String contrasena;

    public Usuario(UsuarioAutorDTO usuarioDTO){
        this.nombre = usuarioDTO.nombre();
    }

    public Usuario(UsuarioDTO usuarioDTO){
        this.nombre = usuarioDTO.nombre();
        this.correo = usuarioDTO.correo();
        this.contrasena = usuarioDTO.contrasena();
    }

    public Usuario(RegisterUserDTO registerUserDTO){
        this.nombre = registerUserDTO.fullName();
        this.correo = registerUserDTO.email();
        this.contrasena = registerUserDTO.password();
    }

    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


