package com.example.formula1tfc.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    private Long id;

    //@Email(regexp = ".*@.*\\..*", message = "Email debe ser correcto")
    //private String correo;

    //@NotBlank(message = "Debes incluir una contraseña")
    //private String password;

    private String token;

}