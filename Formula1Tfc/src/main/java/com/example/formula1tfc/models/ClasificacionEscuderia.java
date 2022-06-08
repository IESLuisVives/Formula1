package com.example.formula1tfc.models;

import lombok.Data;
@Data
public class ClasificacionEscuderia {
        private String posicion;
        private String nombreEscuderia;
        private String puntos;

        public ClasificacionEscuderia() {
        }

        public ClasificacionEscuderia(String posicion, String nombreEscuderia, String puntos) {
                this.posicion = posicion;
                this.nombreEscuderia = nombreEscuderia;
                this.puntos = puntos;
        }
}
