package com.example.formula1tfc.repositories;

import com.example.formula1tfc.models.ClasificacionPiloto;
import com.example.formula1tfc.repository.ClasificacionRepository;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(classes = {ClasificacionRepository.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClasificacionRepositoryTest {
    @MockBean
    private ClasificacionRepository repository;
    private ClasificacionPiloto clasificacionPiloto;
    private List<ClasificacionPiloto> listaClasificacion;

    @BeforeAll
    void beforeAll() {
        clasificacionPiloto = new ClasificacionPiloto("posicion","nombre","puntos","escudera","bandera");
        listaClasificacion = new ArrayList<>();
        listaClasificacion.add(clasificacionPiloto);
    }
    @Test
    @Order(1)
    public void guardar() {

        when(repository.save(clasificacionPiloto)).thenReturn(clasificacionPiloto);
        ClasificacionPiloto response = repository.save(clasificacionPiloto);
        assertAll(
                () -> assertEquals(clasificacionPiloto.getNombrePiloto(), response.getNombrePiloto()),
                () -> assertEquals(clasificacionPiloto.getPuntos(), response.getPuntos()),
                () -> assertEquals(clasificacionPiloto.getBandera(),response.getBandera()),
                () -> assertEquals(clasificacionPiloto.getPosicion(),response.getPosicion()),
                () -> assertEquals(clasificacionPiloto.getBandera(),response.getBandera())
        );
        verify(repository, times(1)).save(clasificacionPiloto);
    }
    @Test
    @Order(2)
    public void getAllClasificacion() {
        when(repository.findAll()).thenReturn(listaClasificacion);
        assertTrue(repository.findAll().size() == listaClasificacion.size());
        verify(repository, times(1)).findAll();
    }

}
