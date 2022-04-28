package com.example.formula1tfc.models;

import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Circuito {
    private int id;
    private String pais;
    private String vueltaRapida;
    private String longitud;
    private String imagen;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Basic
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    @Basic
    public String getVueltaRapida() {
        return vueltaRapida;
    }

    public void setVueltaRapida(String vueltaRapida) {
        this.vueltaRapida = vueltaRapida;
    }
    @Basic
    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    @Basic
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
