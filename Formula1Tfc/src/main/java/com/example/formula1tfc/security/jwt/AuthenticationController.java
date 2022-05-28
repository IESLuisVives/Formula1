package com.example.formula1tfc.security.jwt;

import com.example.formula1tfc.dto.UsuarioDTO;
import com.example.formula1tfc.mapper.UsuarioMapper;
import com.example.formula1tfc.models.UserRole;
import com.example.formula1tfc.models.Usuario;
import com.example.formula1tfc.security.jwt.model.JwtUserResponse;
import com.example.formula1tfc.security.jwt.model.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider tokenProvider;
    private final UsuarioMapper usuarioMapper;


    @PostMapping("/auth/login")
    public JwtUserResponse login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Usuario user = (Usuario) authentication.getPrincipal();
        String jwtToken = tokenProvider.generateToken(authentication);
        return convertUserToUserResponse(user, jwtToken);
    }


    @GetMapping("/user/me")
    public UsuarioDTO me(@AuthenticationPrincipal Usuario user) {
        return usuarioMapper.toDTO(user);
    }

    private JwtUserResponse convertUserToUserResponse(Usuario user, String jwtToken) {
        return JwtUserResponse
                .jwtUserResponseBuilder()
                .correo(user.getCorreo())
                .username(user.getUsername())
                .password(user.getPassword())
                .imagen(user.getImagen())
                .roles(user.getRoles().stream().map(UserRole::name).collect(Collectors.toSet()))
                .token(jwtToken)
                .build();
    }
}
