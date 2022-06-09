package com.example.formula1tfc.controllers;

import com.example.formula1tfc.controller.ClasificacionController;
import com.example.formula1tfc.models.ClasificacionPiloto;
import com.example.formula1tfc.repository.ClasificacionEscuderiaRepository;
import com.example.formula1tfc.repository.ClasificacionRepository;
import com.example.formula1tfc.service.uploads.ClasificacionService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = {ClasificacionController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClasificacionPilotoControllerTest {
    @MockBean
    private ClasificacionService service;
    @MockBean
    private ClasificacionRepository repository;
    @MockBean
    private ClasificacionEscuderiaRepository repository2;
    @InjectMocks
    private ClasificacionController controller;

    @Autowired
    public ClasificacionPilotoControllerTest(ClasificacionService service, ClasificacionRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @Test
    @Order(1)
    void getAllTestMock() {
        ClasificacionPiloto clasificacionEscuderia = new ClasificacionPiloto("1","escuderia","puntos","bandera","bandera");
        List<ClasificacionPiloto> listaClasificacion = new ArrayList<>();
        listaClasificacion.add(clasificacionEscuderia);
        when(repository.findAll()).thenReturn(listaClasificacion);
        ResponseEntity<List<ClasificacionPiloto>> response = controller.getAllClasificacionPilotos2();
        List<ClasificacionPiloto> res = response.getBody();
        System.out.println(repository.findAll());
        assertAll(
                () -> assertEquals(HttpStatus.OK.value(), response.getStatusCode().value()),
                () -> assertEquals(res.size(), listaClasificacion.size())
        );
    }
}
