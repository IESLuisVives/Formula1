package com.example.formula1tfc.controllers;

import com.example.formula1tfc.controller.CircuitoController;
import com.example.formula1tfc.dto.CircuitoDTO;
import com.example.formula1tfc.mapper.CircuitoMapper;
import com.example.formula1tfc.models.Circuito;
import com.example.formula1tfc.repository.CircuitoRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ContextConfiguration(classes = {CircuitoController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CircuitoControllerTest {

    private List<CircuitoDTO> circuitoDTOList;
    private List<Circuito> circuitoList;
    @InjectMocks
    private CircuitoController controller;
    @MockBean
    private CircuitoRepository repository;
    @MockBean
    private CircuitoMapper mapper;
    private Circuito circuito;
    private CircuitoDTO circuitoDTO;

    @BeforeAll
    void beforeAll() {
        controller = new CircuitoController(repository,mapper);
        circuito = new Circuito(1,"pais", "nombre", "vuelta", "longitud","imagen");
        circuitoDTO = new CircuitoDTO(1,"pais", "nombre", "vuelta", "longitud","imagen");
        circuitoList = new ArrayList<>();
        circuitoList.add(circuito);
        circuitoDTOList = new ArrayList<>();
        circuitoDTOList.add(circuitoDTO);

    }

    @Test
    @Order(1)
    void getAll() {
        when(repository.findAll()).thenReturn(circuitoList);
        when(mapper.toDTOList(circuitoList)).thenReturn(circuitoDTOList);
        ResponseEntity<List<CircuitoDTO>> response = controller.getAllCircuitos();
        List<CircuitoDTO> responseList = response.getBody();
        assertAll(
                () -> assertTrue(responseList.size() > 0),
                () -> assertEquals(response.getStatusCode(), HttpStatus.OK),
                () -> assertEquals(circuitoList.size(), responseList.size()),
                () -> assertEquals(circuitoDTOList.size(), responseList.size()),
                () -> assertEquals(circuitoList.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(circuitoDTOList.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(circuitoList.get(0).getPais(), responseList.get(0).getPais()),
                () -> assertEquals(circuitoDTOList.get(0).getPais(), responseList.get(0).getPais()),
                () -> assertEquals(circuitoList.get(0).getNombreCircuito(), responseList.get(0).getNombreCircuito()),
                () -> assertEquals(circuitoDTOList.get(0).getNombreCircuito(), responseList.get(0).getNombreCircuito()),
                () -> assertEquals(circuitoList.get(0).getLongitud(), responseList.get(0).getLongitud()),
                () -> assertEquals(circuitoDTOList.get(0).getLongitud(), responseList.get(0).getLongitud()),
                () -> assertEquals(circuitoList.get(0).getVueltaRapida(), responseList.get(0).getVueltaRapida()),
                () -> assertEquals(circuitoDTOList.get(0).getVueltaRapida(), responseList.get(0).getVueltaRapida()),
                () -> assertEquals(circuitoList.get(0).getImagen(), responseList.get(0).getImagen()),
                () -> assertEquals(circuitoDTOList.get(0).getImagen(), responseList.get(0).getImagen())



        );
        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).toDTOList(circuitoList);
    }


    @Test
    @Order(2)
    void postPiloto() throws Exception {
        when(repository.insert(circuito)).thenReturn(circuito);
        when(mapper.toModel(circuitoDTO)).thenReturn(circuito);
        when(mapper.toDTO(circuito)).thenReturn(circuitoDTO);
        ResponseEntity<CircuitoDTO> response = controller.postCircuito(circuitoDTO);
        System.out.println(response);
        CircuitoDTO clienteDTOResponse = response.getBody();
        assertAll(
                () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()),
                () -> assertEquals(circuito.getId(), clienteDTOResponse.getId())

        );
        verify(mapper, times(1)).toModel(circuitoDTO);
        verify(mapper, times(1)).toDTO(circuito);
        verify(repository, times(1)).insert(circuito);
    }

    @Test
    @Order(3)
    void getPilotoById() {
        when(mapper.toDTO(circuito)).thenReturn(circuitoDTO);
        when(repository.findById(1)).thenReturn(Optional.of(circuito));
        ResponseEntity response = controller.getCircuitoById(1);
        CircuitoDTO clienteResponse = (CircuitoDTO) response.getBody();
        assertAll(
                () -> assertNotNull(clienteResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(circuitoDTO.getId(), clienteResponse.getId())


        );
        verify(mapper, times(1)).toDTO(circuito);
        verify(repository, times(1)).findById(1);
    }

    @Test
    @Order(5)
    void updateCliente() {
        when(repository.save(circuito)).thenReturn(circuito);
        when(mapper.toDTO(circuito)).thenReturn(circuitoDTO);
        when(mapper.toModel(circuitoDTO)).thenReturn(circuito);
        circuitoDTO.setNombreCircuito("edit");
        ResponseEntity response = controller.updateCircuito(circuitoDTO);
        System.out.println(response);
        CircuitoDTO clienteResponse = (CircuitoDTO) response.getBody();
        assertAll(
                () -> assertNotNull(clienteResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(circuitoDTO.getId(), clienteResponse.getId()),
                () -> assertEquals(circuitoDTO.getNombreCircuito(), clienteResponse.getNombreCircuito())

        );
        verify(mapper, times(1)).toModel(circuitoDTO);
        verify(mapper, times(1)).toDTO(circuito);
        verify(repository, times(1)).save(circuito);
    }
    @Test
    @Order(6)
    void deleteCliente() {
        doNothing().when(repository).deleteById(1);
        when(repository.findById(1)).thenReturn(Optional.empty());
        ResponseEntity response = controller.deleteCircuito(1);
        assertAll(
                () -> assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode())
        );
        verify(repository, times(1)).deleteById(1);
        verify(repository, times(1)).findById(1);
    }
}
