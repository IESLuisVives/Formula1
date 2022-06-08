package com.example.formula1tfcfront.aplication.rest.model;

public class ClasificacionEscuderia {
    private int posicion;
    private String nombreEscuderia;
    private int puntos;

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombreEscuderia() {
        return nombreEscuderia;
    }

    public void setNombreEscuderia(String nombreEscuderia) {
        this.nombreEscuderia = nombreEscuderia;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
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
