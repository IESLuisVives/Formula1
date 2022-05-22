package com.example.formula1tfcfront.aplication.rest.model;

public class Piloto {
    private int id;
    private String nombre;
    private String edad;
    private String imagen;
    private String escuderia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    @Override
    public String toString() {
        return nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", imagen='" + imagen + '\'' +
                ", escuderia='" + escuderia + '\'' +
                '}';
    }
}
