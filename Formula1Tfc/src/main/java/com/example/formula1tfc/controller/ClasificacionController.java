package com.example.formula1tfc.controller;

import com.example.formula1tfc.configuration.views.Views;
import com.example.formula1tfc.dto.CircuitoDTO;
import com.example.formula1tfc.dto.ClasificacionDTO;
import com.example.formula1tfc.dto.PilotosDTO;
import com.example.formula1tfc.error.GeneralError;
import com.example.formula1tfc.mapper.ClasificacionMapper;
import com.example.formula1tfc.models.Clasificacion;
import com.example.formula1tfc.models.Pilotos;
import com.example.formula1tfc.repository.ClasificacionRepository;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clasificacion")
@RequiredArgsConstructor
public class ClasificacionController {
    private final ClasificacionRepository repository;
    private final ClasificacionMapper mapper;

    @ApiOperation(value = "Get All Clasificaciones", notes = "Devuelve una lista de pilotos.")
    @ApiResponse(code = 200, message = "OK", response = ClasificacionDTO.class)
    @JsonView(Views.Clasificacion.class)
    @GetMapping(value = "/all")
    public ResponseEntity<List<ClasificacionDTO>> getAllClasificacion() {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTOList(repository.findAll()));
    }

    @ApiOperation(value = "Get Clasificacion By Id", notes = "Devolverá una clasificacion.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ClasificacionDTO.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = GeneralError.class)
    })
    @JsonView(Views.Clasificacion.class)
    @GetMapping("/id")
    public ResponseEntity getClasificacionById(@RequestParam(name = "id", required = true) int id) {
        Optional<Clasificacion> pilotos = repository.findById(id);
        if (pilotos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(pilotos.get()));
        }
    }

    @ApiOperation(value = "Post Clasificacion", notes = "Devuelve la clasificacion.")
    @ApiResponse(code = 201, message = "Created", response = ClasificacionDTO.class)
    @JsonView(Views.Clasificacion.class)
    @PostMapping("/post")
    public ResponseEntity<ClasificacionDTO> postClasificacion(@RequestBody ClasificacionDTO clasificacionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(repository.insert(mapper.toModel(clasificacionDTO))));
    }

    @ApiOperation(value = "Delete Clasificacion", notes = "Devolverá una respuesta sin cuerpo.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content", response = ClasificacionDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralError.class)
    })
    @JsonView(Views.Clasificacion.class)
    @DeleteMapping("/delete")
    public ResponseEntity deletePiloto(@RequestParam(name = "id", required = true) int id) {
        repository.deleteById(id);
        Optional<Clasificacion> clasificacion = repository.findById(id);
        if (clasificacion.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        }
    }

    @ApiOperation(value = "Put Clasificacion", notes = "Devuelve la clasificacion modificada.")
    @ApiResponse(code = 200, message = "OK", response = ClasificacionDTO.class)
    @JsonView(Views.Clasificacion.class)
    @PutMapping("/update")
    public ResponseEntity<ClasificacionDTO> updateClasificacion(@RequestBody ClasificacionDTO clasificacionDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(repository.save(mapper.toModel(clasificacionDTO))));
    }
}
