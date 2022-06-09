package com.example.formula1tfc.controllers;

import com.example.formula1tfc.controller.PilotoController;
import com.example.formula1tfc.dto.PilotosDTO;
import com.example.formula1tfc.mapper.PilotosMapper;
import com.example.formula1tfc.models.Pilotos;
import com.example.formula1tfc.repository.PilotosRepository;
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
@ContextConfiguration(classes = {PilotoController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PilotoControllerTest {

    private List<PilotosDTO> pilotosDTOList;
    private List<Pilotos> pilotosList;
    @InjectMocks
    private PilotoController controller;
    @MockBean
    private PilotosRepository repository;
    @MockBean
    private PilotosMapper mapper;
    private Pilotos piloto;
    private PilotosDTO pilotosDTO;


    @BeforeAll
    void beforeAll() {
        controller = new PilotoController(repository,mapper);
        piloto = new Pilotos(1,"piloto", "edad", "imagen", "escuderia");
        pilotosDTO = new PilotosDTO(1,"piloto", "edad", "imagen", "escuderia");
        pilotosList = new ArrayList<>();
        pilotosList.add(piloto);
        pilotosDTOList = new ArrayList<>();
        pilotosDTOList.add(pilotosDTO);

    }

    @Test
    @Order(1)
    void getAll() {
        when(repository.findAll()).thenReturn(pilotosList);
        when(mapper.toDTOList(pilotosList)).thenReturn(pilotosDTOList);
        ResponseEntity<List<PilotosDTO>> response = controller.getAllPilotos();
        List<PilotosDTO> responseList = response.getBody();
        assertAll(
                () -> assertTrue(responseList.size() > 0),
                () -> assertEquals(response.getStatusCode(), HttpStatus.OK),
                () -> assertEquals(pilotosList.size(), responseList.size()),
                () -> assertEquals(pilotosDTOList.size(), responseList.size()),
                () -> assertEquals(pilotosList.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(pilotosDTOList.get(0).getId(), responseList.get(0).getId()),
                () -> assertEquals(pilotosList.get(0).getNombre(), responseList.get(0).getNombre()),
                () -> assertEquals(pilotosDTOList.get(0).getNombre(), responseList.get(0).getNombre()),
                () -> assertEquals(pilotosList.get(0).getEdad(), responseList.get(0).getEdad()),
                () -> assertEquals(pilotosDTOList.get(0).getEdad(), responseList.get(0).getEdad()),
                () -> assertEquals(pilotosList.get(0).getEscuderia(), responseList.get(0).getEscuderia()),
                () -> assertEquals(pilotosDTOList.get(0).getEscuderia(), responseList.get(0).getEscuderia()),
                () -> assertEquals(pilotosList.get(0).getImagen(), responseList.get(0).getImagen()),
                () -> assertEquals(pilotosDTOList.get(0).getImagen(), responseList.get(0).getImagen())



        );
        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).toDTOList(pilotosList);
    }


    @Test
    @Order(2)
    void postPiloto() throws Exception {
        when(repository.insert(piloto)).thenReturn(piloto);
        when(mapper.toModel(pilotosDTO)).thenReturn(piloto);
        when(mapper.toDTO(piloto)).thenReturn(pilotosDTO);
        ResponseEntity<PilotosDTO> response = controller.postPiloto(pilotosDTO);
        System.out.println(response);
        PilotosDTO clienteDTOResponse = response.getBody();
        assertAll(
                () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()),
                () -> assertEquals(piloto.getId(), clienteDTOResponse.getId())

        );
        verify(mapper, times(1)).toModel(pilotosDTO);
        verify(mapper, times(1)).toDTO(piloto);
        verify(repository, times(1)).insert(piloto);
    }

    @Test
    @Order(3)
    void getPilotoById() {
        when(mapper.toDTO(piloto)).thenReturn(pilotosDTO);
        when(repository.findById(1)).thenReturn(Optional.of(piloto));
        ResponseEntity response = controller.getPilotoById(1);
        PilotosDTO clienteResponse = (PilotosDTO) response.getBody();
        assertAll(
                () -> assertNotNull(clienteResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(pilotosDTO.getId(), clienteResponse.getId())


        );
        verify(mapper, times(1)).toDTO(piloto);
        verify(repository, times(1)).findById(1);
    }

    @Test
    @Order(5)
    void updateCliente() {
        when(repository.save(piloto)).thenReturn(piloto);
        when(mapper.toDTO(piloto)).thenReturn(pilotosDTO);
        when(mapper.toModel(pilotosDTO)).thenReturn(piloto);
        pilotosDTO.setNombre("edit");
        ResponseEntity response = controller.updatePiloto(pilotosDTO);
        System.out.println(response);
        PilotosDTO clienteResponse = (PilotosDTO) response.getBody();
        assertAll(
                () -> assertNotNull(clienteResponse),
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(pilotosDTO.getId(), clienteResponse.getId()),
                () -> assertEquals(pilotosDTO.getNombre(), clienteResponse.getNombre())

        );
        verify(mapper, times(1)).toModel(pilotosDTO);
        verify(mapper, times(1)).toDTO(piloto);
        verify(repository, times(1)).save(piloto);
    }
    @Test
    @Order(6)
    void deleteCliente() {
        doNothing().when(repository).deleteById(1);
        when(repository.findById(1)).thenReturn(Optional.empty());
        ResponseEntity response = controller.deletePiloto(1);
        assertAll(
                () -> assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode())
        );
        verify(repository, times(1)).deleteById(1);
        verify(repository, times(1)).findById(1);
    }
}
