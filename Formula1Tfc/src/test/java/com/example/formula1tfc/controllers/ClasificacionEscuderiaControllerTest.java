package com.example.formula1tfc.controllers;

import com.example.formula1tfc.controller.ClasificacionController;
import com.example.formula1tfc.models.ClasificacionEscuderia;
import com.example.formula1tfc.repository.ClasificacionEscuderiaRepository;
import com.example.formula1tfc.service.uploads.ClasificacionService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = {ClasificacionController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClasificacionEscuderiaControllerTest {

    private List<ClasificacionEscuderia> clasificacionEscuderiaList = new ArrayList<>();
    @MockBean
    private ClasificacionService service;
    @MockBean
    private ClasificacionEscuderiaRepository repository;
    @InjectMocks
    private ClasificacionController controller = new ClasificacionController(service);


    private ClasificacionEscuderia clasificacionEscuderia = new ClasificacionEscuderia("1","escuderia","1");;
    @Test
    @Order(1)
    void getAll(){

    }
}
