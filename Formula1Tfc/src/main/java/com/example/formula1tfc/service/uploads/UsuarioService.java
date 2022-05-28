package com.example.formula1tfc.service.uploads;

import com.example.formula1tfc.dto.CreateUserDTO;
import com.example.formula1tfc.models.UserRole;
import com.example.formula1tfc.models.Usuario;
import com.example.formula1tfc.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;

    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findUsuarioById(Long usuarioId) {
        return usuarioRepository.findById(usuarioId);
    }

    public Optional<Usuario> findUserByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public Usuario saveUsuario(CreateUserDTO newUsuario) throws Exception {

        Usuario usuario = Usuario.builder()
                    .username(newUsuario.getUsername())
                    .password(passwordEncoder.encode(newUsuario.getPassword()))
                    .correo(newUsuario.getCorreo())
                    .imagen(newUsuario.getImagen())
                    .roles(Stream.of(UserRole.USER).collect(Collectors.toSet()))
                    .build();

            return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> updateUsuario(Usuario usuario, Usuario usuarioNuevo) {
        Optional<Usuario> usuario1 = findUsuarioById(usuario.getId());
        usuario1.ifPresent(u -> {
            u.setId(usuarioNuevo.getId());
            u.setUsername(usuarioNuevo.getUsername());
            u.setCorreo(usuarioNuevo.getCorreo());
            u.setPassword(usuarioNuevo.getPassword());
            u.setLogin(usuarioNuevo.getLogin());
            usuarioRepository.save(u);

        });
        return usuario1;
    }

    public void deleteUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

}