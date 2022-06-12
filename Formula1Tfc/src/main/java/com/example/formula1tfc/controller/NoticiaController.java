package com.example.formula1tfc.controller;

import com.example.formula1tfc.models.Noticia;
import com.example.formula1tfc.service.uploads.NoticiaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/noticia")
@RequiredArgsConstructor
public class NoticiaController {

    private final NoticiaService noticiaService;

    @ApiOperation(value = "Get All Noticias", notes = "Devuelve una lista de noticias de formula 1.")
    @ApiResponse(code = 200, message = "OK", response = Noticia.class)
    @GetMapping("/all")
    public ResponseEntity<Set<Noticia>> getAllNoticias(){
        return ResponseEntity.status(HttpStatus.OK).body(noticiaService.extraerNoticiasPagina2());
    }
}
