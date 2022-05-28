package com.example.formula1tfc.security.jwt.model;

import com.example.formula1tfc.dto.UsuarioDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class JwtUserResponse extends UsuarioDTO {
    private String token;

    @Builder(builderMethodName = "jwtUserResponseBuilder")
    public JwtUserResponse(long id, @NotBlank(message = "Debes introducir un nombre") String username, @NotBlank(message = "Debes introducir un correo") String correo, String password, String imagen, Set<String> roles, String token) {
        super(id, username, correo, password, imagen, roles);
        this.token = token;
    }
}
