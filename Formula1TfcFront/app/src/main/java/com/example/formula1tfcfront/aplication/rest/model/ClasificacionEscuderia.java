package com.example.formula1tfcfront.aplication.rest.model;

public class ClasificacionEscuderia {
    private String posicion;
    private String nombreEscuderia;
    private String puntos;

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombreEscuderia() {
        return nombreEscuderia;
    }

    public void setNombreEscuderia(String nombreEscuderia) {
        this.nombreEscuderia = nombreEscuderia;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return
                "posicion='" + posicion + '\'' +
                ", nombreEscuderia='" + nombreEscuderia + '\'' +
                ", puntos='" + puntos + '\'' +
                '}';
    }
}
