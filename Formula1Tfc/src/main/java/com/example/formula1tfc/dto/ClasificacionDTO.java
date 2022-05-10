package com.example.formula1tfc.dto;

import com.example.formula1tfc.configuration.views.Views;
import com.example.formula1tfc.models.Pilotos;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class ClasificacionDTO {
    @JsonView(Views.Clasificacion.class)
    @ApiModelProperty(value = "Id clasificacion", dataType = "int", position = 1)
    private int id;
    @JsonView(Views.Clasificacion.class)
    @ApiModelProperty(value = "Lista pilotos", dataType = "List", position = 2)
    List<Pilotos> listaPilotos;

    public ClasificacionDTO() {
    }

    public ClasificacionDTO(int id, List<Pilotos> listaPilotos) {
        this.id = id;
        this.listaPilotos = listaPilotos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Pilotos> getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(List<Pilotos> listaPilotos) {
        this.listaPilotos = listaPilotos;
    }
}
