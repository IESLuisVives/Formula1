package com.example.formula1tfc.mapper;

import com.example.formula1tfc.dto.CreateUserDTO;
import com.example.formula1tfc.dto.UsuarioDTO;
import com.example.formula1tfc.models.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UsuarioMapper {
    private final ModelMapper modelMapper;

    public UsuarioDTO toDTO(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
        // return UsuarioDTO.builder()
        //         .username(usuario.getUsername())
        //       //Introducir el resto de datos
        //       .roles(usuario.getRoles().stream().map(UserRole::name).collect(Collectors.toSet()))
        //       .build();
    }

    public Usuario fromDTO(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
        // return Usuario.builder()
        //        .username(usuarioDTO.getUsername())
        //       //Introducir el resto de datos
        //       .build();


    }

    public Usuario fromCreateDTOtoUsuario(CreateUserDTO nuevoUsuario) {
        return modelMapper.map(nuevoUsuario, Usuario.class);
    }

    public List<UsuarioDTO> toDTO(List<Usuario> usuario) {
        return usuario.stream().map(this::toDTO).collect(Collectors.toList());
    }

}
