package com.example.formula1tfc.dto;

import io.swagger.annotations.ApiModelProperty;

public class PilotosDTO {
    @ApiModelProperty(value = "Id piloto", dataType = "int", position = 1)
    private int id;
    @ApiModelProperty(value = "Nombre", dataType = "String", position = 2)
    private String nombre;
    @ApiModelProperty(value = "Edad", dataType = "String", position = 3)
    private String edad;
    @ApiModelProperty(value = "Imagen", dataType = "String", position = 4)
    private String imagen;
    @ApiModelProperty(value = "Escuderia", dataType = "String", position = 5)
    private String escuderia;

    public PilotosDTO() {
    }

    public PilotosDTO(int id, String nombre, String edad, String imagen, String escuderia) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.imagen = imagen;
        this.escuderia = escuderia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }
}
