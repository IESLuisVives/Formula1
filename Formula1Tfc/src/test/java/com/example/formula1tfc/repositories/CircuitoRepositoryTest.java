package com.example.formula1tfc.repositories;

import com.example.formula1tfc.models.Circuito;
import com.example.formula1tfc.repository.CircuitoRepository;
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
@ContextConfiguration(classes = {CircuitoRepository.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CircuitoRepositoryTest {

    @MockBean
    private CircuitoRepository repository;
    private Circuito circuito;
    private List<Circuito> listaCircuitos;

    @BeforeAll
    void beforeAll() {
        circuito = new Circuito(1,"pais","nombre","vueltaRapida","longitud","imagen");
        listaCircuitos = new ArrayList<>();
        listaCircuitos.add(circuito);
    }

    @Test
    @Order(1)
    public void guardar() {

        when(repository.save(circuito)).thenReturn(circuito);
        Circuito response = repository.save(circuito);
        assertAll(
                () -> assertEquals(circuito.getId(), response.getId()),
                () -> assertEquals(circuito.getNombreCircuito(), response.getNombreCircuito()),
                () -> assertEquals(circuito.getImagen(),response.getImagen()),
                () -> assertEquals(circuito.getVueltaRapida(),response.getVueltaRapida()),
                () -> assertEquals(circuito.getLongitud(),response.getLongitud())
        );
        verify(repository, times(1)).save(circuito);
    }
    @Test
    @Order(2)
    public void getAllCircuito() {
        when(repository.findAll()).thenReturn(listaCircuitos);
        assertTrue(repository.findAll().size() == listaCircuitos.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    @Order(3)
    public void getCircuitoById() {
        when(repository.save(circuito)).thenReturn(circuito);
        when(repository.findById(circuito.getId())).thenReturn(Optional.of(circuito));
        Circuito response = repository.save(circuito);
        Circuito usuarioId = repository.findById(response.getId()).get();
        assertAll(
                () -> assertNotNull(usuarioId),
                () -> assertEquals(response.getNombreCircuito(), usuarioId.getNombreCircuito()),
                () -> assertEquals(response.getPais(), usuarioId.getPais()),
                () -> assertEquals(response.getImagen(), usuarioId.getImagen()),
                () -> assertEquals(response.getLongitud(), usuarioId.getLongitud()),
                () -> assertEquals(response.getVueltaRapida(), usuarioId.getVueltaRapida())
        );
        verify(repository, times(1)).save(circuito);
        verify(repository, times(1)).findById(circuito.getId());
    }
    @Test
    @Order(4)
    public void updateCircuito() {
        when(repository.save(circuito)).thenReturn(circuito);
        when(repository.findById(circuito.getId())).thenReturn(Optional.of(circuito));
        Circuito user = repository.save(circuito);
        Circuito res = repository.findById(user.getId()).get();
        res.setNombreCircuito("Usuario de prueba modificado");
        assertAll(
                () -> assertNotNull(res),
                () -> assertEquals(user.getNombreCircuito(), res.getNombreCircuito()),
                () -> assertEquals(user.getImagen(), res.getImagen()),
                () -> assertEquals(user.getVueltaRapida(), res.getVueltaRapida()),
                () -> assertEquals(user.getPais(), res.getPais()),
                () -> assertEquals(user.getLongitud(), res.getLongitud())
        );
        verify(repository, times(1)).save(circuito);
        verify(repository, times(1)).findById(circuito.getId());
    }
    @Test
    @Order(5)
    public void deleteCircuito() {

        doNothing().when(repository).deleteById(circuito.getId());
        repository.deleteById(circuito.getId());
        assertTrue(repository.findById(circuito.getId()).isEmpty());


        verify(repository, times(1)).deleteById(circuito.getId());
        verify(repository, times(1)).findById(circuito.getId());
    }
}
