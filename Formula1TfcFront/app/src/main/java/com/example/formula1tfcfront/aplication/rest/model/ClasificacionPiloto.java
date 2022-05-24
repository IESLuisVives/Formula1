package com.example.formula1tfcfront.aplication.rest.model;

public class ClasificacionPiloto {
    private String posicion;
    private String nombrePiloto;
    private String puntos;
    private String bandera;

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombrePiloto() {
        return nombrePiloto;
    }

    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    @Override
    public String toString() {
        return
                "posicion='" + posicion + '\'' +
                ", nombrePiloto='" + nombrePiloto + '\'' +
                ", puntos='" + puntos + '\'' +
                ", bandera='" + bandera + '\'' +
                '}';
    }
}
