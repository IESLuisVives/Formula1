package com.example.formula1tfc.controller;


import com.example.formula1tfc.dto.CircuitoDTO;
import com.example.formula1tfc.error.GeneralError;
import com.example.formula1tfc.mapper.CircuitoMapper;
import com.example.formula1tfc.models.Circuito;
import com.example.formula1tfc.repository.CircuitoRepository;
import com.example.formula1tfc.service.uploads.StorageService;
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
@RequestMapping("/circuito")
@RequiredArgsConstructor
public class CircuitoController {
    private final CircuitoRepository repository;
    private final StorageService storageService;
    private final CircuitoMapper mapper;

    @ApiOperation(value = "Get All Circuitos", notes = "Devuelve una lista de circuitos.")
    @ApiResponse(code = 200, message = "OK", response = CircuitoDTO.class)
    @GetMapping(value = "/all")
    public ResponseEntity<List<CircuitoDTO>> getAllCircuitos() {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTOList(repository.findAll()));
    }

    @ApiOperation(value = "Get Circuito By Id", notes = "Devolverá el circuito en caso de encontrarlo.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = CircuitoDTO.class),
            @ApiResponse(code = 400, message = "BAD_REQUEST", response = GeneralError.class)
    })
    @GetMapping("/{id}")
    public ResponseEntity getCircuitoById(@PathVariable int id) {
        Optional<Circuito> circuito = repository.findById(id);
        if (circuito.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(circuito.get()));
        }
    }

    @ApiOperation(value = "Post Circuito", notes = "Devuelve el circuito que se ha insertado.")
    @ApiResponse(code = 201, message = "Created", response = CircuitoDTO.class)
    @PostMapping("/post")
    public ResponseEntity<CircuitoDTO> postCircuito(@RequestBody CircuitoDTO circuitoDTO, @RequestPart("file") MultipartFile file) {
        Circuito circuito = mapper.toModel(circuitoDTO);
        if (!file.isEmpty()){
            String imagen = storageService.store(file);
            String urlImagen = storageService.getUrl(imagen);
            circuito.setImagen(urlImagen);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(repository.insert(circuito)));
    }

    @ApiOperation(value = "Delete Circuito", notes = "Devolverá una respuesta sin cuerpo.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content", response = CircuitoDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralError.class)
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCircuito(@PathVariable int id) {
        repository.deleteById(id);
        Optional<Circuito> circuito = repository.findById(id);
        if (circuito.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GeneralError());
        }
    }

    @ApiOperation(value = "Put Circuito", notes = "Devuelve el circuito que ha sido modificado.")
    @ApiResponse(code = 200, message = "OK", response = CircuitoDTO.class)
    @PutMapping("/update")
    public ResponseEntity<CircuitoDTO> updateCircuito(@RequestBody CircuitoDTO circuitoDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(repository.save(mapper.toModel(circuitoDTO))));
    }
}
