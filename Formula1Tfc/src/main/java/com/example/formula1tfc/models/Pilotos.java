package com.example.formula1tfc.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Pilotos {
    private int id;
    private String nombre;
    private String edad;
    private String imagen;
    private String escuderia;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Basic
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Basic
    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    @Basic
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    @Basic
    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }


    public Pilotos(int id, String nombre, String edad, String imagen, String escuderia) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.imagen = imagen;
        this.escuderia = escuderia;
    }
}
