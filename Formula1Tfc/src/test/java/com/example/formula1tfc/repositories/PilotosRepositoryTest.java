package com.example.formula1tfc.repositories;

import com.example.formula1tfc.models.Pilotos;
import com.example.formula1tfc.repository.PilotosRepository;
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
@ContextConfiguration(classes = {PilotosRepository.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PilotosRepositoryTest {
    @MockBean
    private PilotosRepository repository;
    private Pilotos piloto;
    private List<Pilotos> listaPilotos;

    @BeforeAll
    void beforeAll() {
        piloto = new Pilotos(1,"piloto", "edad", "imagen", "escuderia");
        listaPilotos = new ArrayList<>();
        listaPilotos.add(piloto);
    }

    @Test
    @Order(1)
    public void guardar() {

        when(repository.save(piloto)).thenReturn(piloto);
        Pilotos response = repository.save(piloto);
        assertAll(
                () -> assertEquals(piloto.getId(), response.getId()),
                () -> assertEquals(piloto.getNombre(), response.getNombre()),
                () -> assertEquals(piloto.getEdad(),response.getEdad()),
                () -> assertEquals(piloto.getEscuderia(),response.getEscuderia()),
                () -> assertEquals(piloto.getImagen(),response.getImagen())
        );
        verify(repository, times(1)).save(piloto);
    }

    @Test
    @Order(2)
    public void getAllPilotos() {
        when(repository.findAll()).thenReturn(listaPilotos);
        assertTrue(repository.findAll().size() == listaPilotos.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    @Order(3)
    public void getPilotoById() {
        when(repository.save(piloto)).thenReturn(piloto);
        when(repository.findById(piloto.getId())).thenReturn(Optional.of(piloto));
        Pilotos response = repository.save(piloto);
        Pilotos pilotoId = repository.findById(response.getId()).get();
        assertAll(
                () -> assertNotNull(pilotoId),
                () -> assertEquals(response.getNombre(), pilotoId.getNombre()),
                () -> assertEquals(response.getEdad(), pilotoId.getEdad()),
                () -> assertEquals(response.getEscuderia(), pilotoId.getEscuderia()),
                () -> assertEquals(response.getImagen(), pilotoId.getImagen())
        );
        verify(repository, times(1)).save(piloto);
        verify(repository, times(1)).findById(piloto.getId());
    }

    @Test
    @Order(5)
    public void deletePiloto() {


        doNothing().when(repository).deleteById(piloto.getId());
        repository.deleteById(piloto.getId());
        assertTrue(repository.findById(piloto.getId()).isEmpty());


        verify(repository, times(1)).deleteById(piloto.getId());
        verify(repository, times(1)).findById(piloto.getId());
    }
}
