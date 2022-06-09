package com.example.formula1tfc.models;

import lombok.Data;

@Data
public class Noticia {
    private String titulo;
    private String imagen;

    public Noticia() {
    }

    public Noticia(String titulo, String imagen) {
        this.titulo = titulo;
        this.imagen = imagen;
    }
}
