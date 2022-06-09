package com.example.formula1tfc.controllers;

import com.example.formula1tfc.controller.UsuarioController;
import com.example.formula1tfc.dto.UsuarioDTO;
import com.example.formula1tfc.mapper.UsuarioMapper;
import com.example.formula1tfc.models.Usuario;
import com.example.formula1tfc.repository.LoginRepository;
import com.example.formula1tfc.repository.UsuarioRepository;
import com.example.formula1tfc.security.jwt.JwtProvider;
import com.example.formula1tfc.service.uploads.UsuarioService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ContextConfiguration(classes = {UsuarioController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {

    private List<UsuarioDTO> usuarioDTOS;
    private List<Usuario> usuarios;
    @InjectMocks
    private UsuarioController controller;
    @MockBean
    private UsuarioRepository repository;
    @MockBean
    private UsuarioMapper mapper;
    private Usuario usuario;
    private UsuarioDTO usuarioDTO;
    @MockBean
    private  UsuarioService usuarioService;
    @MockBean
    private  AuthenticationManager authenticationManager;
    @MockBean
    private  JwtProvider tokenProvider;
    @MockBean
    private  LoginRepository loginRepository;


    @BeforeAll
    void beforeAll() {
        controller = new UsuarioController(repository,usuarioService,mapper,authenticationManager,tokenProvider,loginRepository);
        usuario = new Usuario("1", "correo", "usuario", "contraseña", "imagen");
        usuarioDTO = new UsuarioDTO("1", "usuario", "correo", "contraseña", "imagen");
        usuarios = new ArrayList<>();
        usuarios.add(usuario);
        usuarioDTOS = new ArrayList<>();
        usuarioDTOS.add(usuarioDTO);

    }

    @Test
    @Order(1)
    void getAll() {
        when(repository.findAll()).thenReturn(usuarios);
        when(mapper.toDTO(usuarios)).thenReturn(usuarioDTOS);
        ResponseEntity<List<UsuarioDTO>> response = controller.getAllUsuarios();
        List<UsuarioDTO> responseList = response.getBody();
        assertAll(
                () -> assertTrue(responseList.size() > 0),
                () -> assertEquals(response.getStatusCode(), HttpStatus.OK),
                () -> assertEquals(usuarios.size(), responseList.size()),
                () -> assertEquals(usuarioDTOS.size(), responseList.size()),
                () -> assertEquals(usuarios.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(usuarioDTOS.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(usuarios.get(0).getCorreo(), responseList.get(0).getCorreo()),
                () -> assertEquals(usuarioDTOS.get(0).getCorreo(), responseList.get(0).getCorreo()),
                () -> assertEquals(usuarios.get(0).getPassword(), responseList.get(0).getPassword()),
                () -> assertEquals(usuarioDTOS.get(0).getPassword(), responseList.get(0).getPassword())
        );
        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).toDTO(usuarios);
    }


    @Test
    @Order(2)
    void postCliente() throws Exception {
        when(usuarioService.saveUsuario(usuarioDTO)).thenReturn(usuario);
        when(mapper.fromDTO(usuarioDTO)).thenReturn(usuario);
        when(mapper.toDTO(usuario)).thenReturn(usuarioDTO);
        ResponseEntity<UsuarioDTO> response = controller.save(usuarioDTO);

        UsuarioDTO clienteDTOResponse = response.getBody();
        assertAll(
                () -> assertNotNull(clienteDTOResponse),
                () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()),
                () -> assertEquals(usuarioDTO.getId(), clienteDTOResponse.getId()),
                () -> assertEquals(usuarioDTO.getPassword(), clienteDTOResponse.getPassword()),
                () -> assertEquals(usuarioDTO.getCorreo(), clienteDTOResponse.getCorreo())
        );
        verify(mapper, times(1)).fromDTO(usuarioDTO);
        verify(mapper, times(1)).toDTO(usuario);
        verify(usuarioService,times(1)).saveUsuario(usuarioDTO);
    }

    @Test
    @Order(3)
    void getClienteById() {
        when(mapper.toDTO(usuario)).thenReturn(usuarioDTO);
        when(repository.findById("1")).thenReturn(Optional.of(usuario));
        ResponseEntity response = controller.findById("1");
        UsuarioDTO clienteResponse = (UsuarioDTO) response.getBody();
        assertAll(
                () -> assertNotNull(clienteResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(usuarioDTO.getId(), clienteResponse.getId()),
                () -> assertEquals(usuarioDTO.getPassword(), clienteResponse.getPassword()),
                () -> assertEquals(usuarioDTO.getCorreo(), clienteResponse.getCorreo())

        );
        verify(mapper, times(1)).toDTO(usuario);
        verify(repository, times(1)).findById("1");
    }

    @Test
    @Order(5)
    void updateCliente() {
        when(repository.save(usuario)).thenReturn(usuario);
        when(mapper.toDTO(usuario)).thenReturn(usuarioDTO);
        usuario.setUsername("pepe");
        ResponseEntity response = controller.update(usuario);
        UsuarioDTO clienteResponse = (UsuarioDTO) response.getBody();
        assertAll(
                () -> assertNotNull(clienteResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(usuarioDTO.getId(), clienteResponse.getId()),
                () -> assertEquals(usuarioDTO.getPassword(), clienteResponse.getPassword()),
                () -> assertEquals(usuarioDTO.getCorreo(), clienteResponse.getCorreo())
        );
        verify(mapper, times(1)).toDTO(usuario);
        verify(repository, times(1)).save(usuario);

    }
    @Test
    @Order(6)
    void deleteCliente() {
        doNothing().when(repository).deleteById("1");
        when(repository.findById("1")).thenReturn(Optional.empty());
        ResponseEntity response = controller.delete("1");
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode())
        );
        verify(repository, times(1)).deleteById("1");
        verify(repository, times(1)).findById("1");
    }
}