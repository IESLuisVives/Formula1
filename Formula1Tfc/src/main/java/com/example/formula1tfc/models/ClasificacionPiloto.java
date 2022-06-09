package com.example.formula1tfc.models;

import lombok.Data;

@Data
public class ClasificacionPiloto {
    private String posicion;
    private String nombrePiloto;
    private String puntos;
    private String escuderia;
    private String bandera;

    public ClasificacionPiloto() {
    }

    public ClasificacionPiloto(String posicion, String nombrePiloto, String puntos, String escuderia, String bandera) {
        this.posicion = posicion;
        this.nombrePiloto = nombrePiloto;
        this.puntos = puntos;
        this.escuderia = escuderia;
        this.bandera = bandera;
    }
}
