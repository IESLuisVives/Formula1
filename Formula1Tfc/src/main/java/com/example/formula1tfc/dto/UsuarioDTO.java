package com.example.formula1tfc.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private String id;

    @NotBlank(message = "Debes introducir un nombre")
    private String username;

    @NotBlank(message = "Debes introducir un correo")
    @Email(regexp = ".*@.*\\..*", message = "Email debe ser correcto")
    private String correo;

    @NotBlank(message = "Debes incluir una contraseña")
    private String password;

    private String imagen;

    private Set<String> roles;

}
