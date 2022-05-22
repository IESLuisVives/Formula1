package com.example.formula1tfc.controller;

import com.example.formula1tfc.configuration.views.Views;
import com.example.formula1tfc.dto.CircuitoDTO;
import com.example.formula1tfc.dto.PilotosDTO;
import com.example.formula1tfc.error.GeneralError;
import com.example.formula1tfc.mapper.CircuitoMapper;
import com.example.formula1tfc.mapper.PilotosMapper;
import com.example.formula1tfc.models.Circuito;
import com.example.formula1tfc.models.Pilotos;
import com.example.formula1tfc.repository.CircuitoRepository;
import com.example.formula1tfc.repository.PilotosRepository;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/piloto")
@RequiredArgsConstructor
public class PilotoController {
    private final PilotosRepository repository;
    private final PilotosMapper mapper;

    @ApiOperation(value = "Get All Pilotos", notes = "Devuelve una lista de pilotos.")
    @ApiResponse(code = 200, message = "OK", response = PilotosDTO.class)
    @JsonView(Views.Pilotos.class)
    @GetMapping(value = "/all")
    public ResponseEntity<List<PilotosDTO>> getAllPilotos() {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTOList(repository.findAll()));
    }

    @ApiOperation(value = "Get Piloto By Id", notes = "Devolverá el piloto en caso de encontrarlo.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = PilotosDTO.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = GeneralError.class)
    })
    @JsonView(Views.Pilotos.class)
    @GetMapping("/id")
    public ResponseEntity getPilotoById(@RequestParam(name = "id", required = true) int id) {
        Optional<Pilotos> pilotos = repository.findById(id);
        if (pilotos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(pilotos.get()));
        }
    }

    @ApiOperation(value = "Post piloto", notes = "Devuelve el piloto que se ha insertado.")
    @ApiResponse(code = 201, message = "Created", response = PilotosDTO.class)
    @JsonView(Views.Pilotos.class)
    @PostMapping("/post")
    public ResponseEntity<PilotosDTO> postPiloto(@RequestBody PilotosDTO pilotosDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(repository.insert(mapper.toModel(pilotosDTO))));
    }

    @ApiOperation(value = "Delete Piloto", notes = "Devolverá una respuesta sin cuerpo.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content", response = CircuitoDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralError.class)
    })
    @JsonView(Views.Pilotos.class)
    @DeleteMapping("/delete")
    public ResponseEntity deletePiloto(@RequestParam(name = "id", required = true) int id) {
        repository.deleteById(id);
        Optional<Pilotos> piloto = repository.findById(id);
        if (piloto.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        }
    }

    @ApiOperation(value = "Put Piloto", notes = "Devuelve el piloto que ha sido modificado.")
    @ApiResponse(code = 200, message = "OK", response = CircuitoDTO.class)
    @JsonView(Views.Pilotos.class)
    @PutMapping("/update")
    public ResponseEntity<PilotosDTO> updatePiloto(@RequestBody PilotosDTO pilotosDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(repository.save(mapper.toModel(pilotosDTO))));
    }
}
