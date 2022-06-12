package com.example.formula1tfc.controller;

import com.example.formula1tfc.models.ClasificacionEscuderia;
import com.example.formula1tfc.models.ClasificacionPiloto;
import com.example.formula1tfc.repository.ClasificacionEscuderiaRepository;
import com.example.formula1tfc.repository.ClasificacionRepository;
import com.example.formula1tfc.service.uploads.ClasificacionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/clasificacion")
@RequiredArgsConstructor
public class ClasificacionController {
    private final ClasificacionService clasificacionService;
    private final ClasificacionEscuderiaRepository clasificacionRepository;
    private final ClasificacionRepository clasificacionRepository2;



    @ApiOperation(value = "Get All Clasificacion Piloto", notes = "Devuelve una lista de clasificacion de pilotos.")
    @ApiResponse(code = 200, message = "OK", response = ClasificacionPiloto.class)
    @GetMapping("/all")
    public ResponseEntity<Set<ClasificacionPiloto>> getAllClasificacionPilotos() {
        return ResponseEntity.status(HttpStatus.OK).body(clasificacionService.extraerClasificacionPilotos());
    }

    @ApiOperation(value = "Get All Clasificacion Escuderia", notes = "Devuelve una lista de clasificacion de escuderias.")
    @ApiResponse(code = 200, message = "OK", response = ClasificacionEscuderia.class)
    @GetMapping("/all/escuderias")
    public ResponseEntity<Set<ClasificacionEscuderia>> getAllClasificacionEscuderias() {
        return ResponseEntity.status(HttpStatus.OK).body(clasificacionService.extraerClasificacionEscuderias());
    }

    @GetMapping("/all/escuderias/test")
    public ResponseEntity<List<ClasificacionEscuderia>> getAllClasificacionEscuderiasTest() {
        return ResponseEntity.status(HttpStatus.OK).body(clasificacionRepository.findAll());
    }
    @GetMapping("/all/test")
    public ResponseEntity<List<ClasificacionPiloto>> getAllClasificacionPilotos2() {
        return ResponseEntity.status(HttpStatus.OK).body(clasificacionRepository2.findAll());
    }

}
