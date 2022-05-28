package com.example.formula1tfc.dto;

import com.example.formula1tfc.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    private String correo;
    private String username;
    private String password;
    private String imagen;
    private Set<UserRole> roles;
}