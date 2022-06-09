package com.example.formula1tfc.repositories;

import com.example.formula1tfc.models.Usuario;
import com.example.formula1tfc.repository.UsuarioRepository;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = {UsuarioRepository.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {


    @MockBean
    private UsuarioRepository repository;
    private Usuario usuario;
    private List<Usuario> listaUsuarios;

    @BeforeAll
    void beforeAll() {
        usuario = new Usuario("1","correo","usuario","contraseña","imagen");
        listaUsuarios = new ArrayList<>();
        listaUsuarios.add(usuario);
    }
    @Test
    @Order(1)
    public void guardar() {

        when(repository.save(usuario)).thenReturn(usuario);
        Usuario response = repository.save(usuario);
        assertAll(
                () -> assertEquals(usuario.getId(), response.getId()),
                () -> assertEquals(usuario.getUsername(), response.getUsername()),
                () -> assertEquals(usuario.getCorreo(),response.getCorreo()),
                () -> assertEquals(usuario.getPassword(),response.getPassword())
        );
        verify(repository, times(1)).save(usuario);
    }
    @Test
    @Order(2)
    public void getAllUsuario() {
        when(repository.findAll()).thenReturn(listaUsuarios);
        assertTrue(repository.findAll().size() == listaUsuarios.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    @Order(3)
    public void getUsuarioById() {
        when(repository.save(usuario)).thenReturn(usuario);
        when(repository.findById(usuario.getId())).thenReturn(Optional.of(usuario));
        Usuario response = repository.save(usuario);
        Usuario usuarioId = repository.findById(response.getId()).get();
        assertAll(
                () -> assertNotNull(usuarioId),
                () -> assertEquals(response.getCorreo(), usuarioId.getCorreo()),
                () -> assertEquals(response.getUsername(), usuarioId.getUsername()),
                () -> assertEquals(response.getPassword(), usuarioId.getPassword())
        );
        verify(repository, times(1)).save(usuario);
        verify(repository, times(1)).findById(usuario.getId());
    }
    @Test
    @Order(4)
    public void updateUsuario() {
        when(repository.save(usuario)).thenReturn(usuario);
        when(repository.findById(usuario.getId())).thenReturn(Optional.of(usuario));
        Usuario user = repository.save(usuario);
        Usuario res = repository.findById(user.getId()).get();
        res.setUsername("Usuario de prueba modificado");
        assertAll(
                () -> assertNotNull(res),
                () -> assertEquals(user.getUsername(), res.getUsername()),
                () -> assertEquals(user.getPassword(), res.getPassword()),
                () -> assertEquals(user.getCorreo(), res.getCorreo())
        );
        verify(repository, times(1)).save(usuario);
        verify(repository, times(1)).findById(usuario.getId());
    }
    @Test
    @Order(5)
    public void deleteUsuario() {


        doNothing().when(repository).deleteById(usuario.getId());
        when(repository.findById(usuario.getId())).thenReturn(Optional.of(usuario));

        repository.deleteById(usuario.getId());
        assertTrue(repository.findById(usuario.getId()).isPresent());

        verify(repository, times(1)).deleteById(usuario.getId());
        verify(repository, times(1)).findById(usuario.getId());


    }

}