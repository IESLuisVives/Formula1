package com.example.formula1tfc.dto;

import io.swagger.annotations.ApiModelProperty;

public class CircuitoDTO {
    @ApiModelProperty(value = "Id circuito", dataType = "int", position = 1)
    private int id;
    @ApiModelProperty(value = "Pais", dataType = "String", position = 2)
    private String pais;
    @ApiModelProperty(value = "Nombre Circuito", dataType = "String", position = 3)
    private String nombreCircuito;
    @ApiModelProperty(value = "Vuelta Rapida", dataType = "String", position = 4)
    private String vueltaRapida;
    @ApiModelProperty(value = "Longitud", dataType = "String", position = 5)
    private String longitud;
    @ApiModelProperty(value = "Imagen", dataType = "String", position = 6)
    private String imagen;

    public CircuitoDTO() {
    }

    public CircuitoDTO(int id, String pais, String nombreCircuito, String vueltaRapida, String longitud, String imagen) {
        this.id = id;
        this.pais = pais;
        this.nombreCircuito = nombreCircuito;
        this.vueltaRapida = vueltaRapida;
        this.longitud = longitud;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombreCircuito() {
        return nombreCircuito;
    }

    public void setNombreCircuito(String nombreCircuito) {
        this.nombreCircuito = nombreCircuito;
    }

    public String getVueltaRapida() {
        return vueltaRapida;
    }

    public void setVueltaRapida(String vueltaRapida) {
        this.vueltaRapida = vueltaRapida;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
