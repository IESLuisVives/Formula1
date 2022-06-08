package com.example.formula1tfc.dto;

import com.example.formula1tfc.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    private String id;
    private String correo;
    private String username;
    private String password;
    private String imagen;
    private Set<UserRole> roles;

    public CreateUserDTO(String correo, String username, String password, String imagen, Set<UserRole> roles) {
        this.id = UUID.randomUUID().toString();
        this.correo = correo;
        this.username = username;
        this.password = password;
        this.imagen = imagen;
        this.roles = roles;
    }

    public CreateUserDTO(String id, String correo, String username, String password, String imagen) {
        this.id = id;
        this.correo = correo;
        this.username = username;
        this.password = password;
        this.imagen = imagen;
    }
}