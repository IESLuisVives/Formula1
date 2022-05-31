package com.example.formula1tfcfront.aplication.rest.model;

public class Noticia {
    private String titulo;
    private String imagen;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Noticia(String titulo, String imagen) {
        this.titulo = titulo;
        this.imagen = imagen;
    }
}
