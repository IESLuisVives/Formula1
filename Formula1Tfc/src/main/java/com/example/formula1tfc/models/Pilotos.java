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
    @ManyToOne
    @JoinColumn(name="clasificacion_id")
    private Clasificacion clasificacion;

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

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Pilotos(int id, String nombre, String edad, String imagen, String escuderia, Clasificacion clasificacion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.imagen = imagen;
        this.escuderia = escuderia;
        this.clasificacion = clasificacion;
    }
}
