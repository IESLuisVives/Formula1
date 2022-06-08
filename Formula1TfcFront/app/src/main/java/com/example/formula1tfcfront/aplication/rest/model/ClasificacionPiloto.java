package com.example.formula1tfcfront.aplication.rest.model;

public class ClasificacionPiloto {
    private int posicion;
    private String nombrePiloto;
    private int puntos;
    private String escuderia;
    private String bandera;

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombrePiloto() {
        return nombrePiloto;
    }

    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    @Override
    public String toString() {
        return "ClasificacionPiloto{" +
                "posicion='" + posicion + '\'' +
                ", nombrePiloto='" + nombrePiloto + '\'' +
                ", puntos='" + puntos + '\'' +
                ", escuderia='" + escuderia + '\'' +
                ", bandera='" + bandera + '\'' +
                '}';
    }
}
