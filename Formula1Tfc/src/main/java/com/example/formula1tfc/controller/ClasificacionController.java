package com.example.formula1tfc.controller;

import com.example.formula1tfc.models.ClasificacionEscuderia;
import com.example.formula1tfc.models.ClasificacionPiloto;
import com.example.formula1tfc.repository.ClasificacionEscuderiaRepository;
import com.example.formula1tfc.service.uploads.ClasificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/clasificacion")
@RequiredArgsConstructor

public class ClasificacionController {
    private final ClasificacionService clasificacionService;




    @GetMapping("/all")
    public ResponseEntity<Set<ClasificacionPiloto>> getAllClasificacionPilotos() {
        return ResponseEntity.status(HttpStatus.OK).body(clasificacionService.extraerClasificacionPilotos());
    }

    @GetMapping("/all/escuderias")
    public ResponseEntity<Set<ClasificacionEscuderia>> getAllClasificacionEscuderias() {
        return ResponseEntity.status(HttpStatus.OK).body(clasificacionService.extraerClasificacionEscuderias());
    }


}
