package com.example.formula1tfcfront.aplication.rest.model;

public class Noticia {
    private String titulo;
    private String imagen;
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return
                titulo + '\'' +
                ", imagen='" + imagen + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
