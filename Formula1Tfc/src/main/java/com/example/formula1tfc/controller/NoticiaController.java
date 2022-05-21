package com.example.formula1tfc.controller;

import com.example.formula1tfc.models.Noticia;
import com.example.formula1tfc.service.uploads.NoticiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/noticia")
@RequiredArgsConstructor
public class NoticiaController {

    private final NoticiaService noticiaService;

    @GetMapping("/all")
    public ResponseEntity<Set<Noticia>> getAllNoticias(){
        return ResponseEntity.status(HttpStatus.OK).body(noticiaService.extraerNoticiasPagina2());
    }
}
