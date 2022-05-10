package com.example.formula1tfc.models;

import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
public class Clasificacion {
    private int clasificacion_id;
    @OneToMany(mappedBy="clasificacion",  cascade = CascadeType.ALL)
    List<Pilotos> listaPilotos;

    @Id
    public int getId() {
        return clasificacion_id;
    }

    public void setId(int id) {
        this.clasificacion_id = id;
    }

    public List<Pilotos> getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(List<Pilotos> listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    public Clasificacion(int id, List<Pilotos> listaPilotos) {
        this.clasificacion_id = id;
        this.listaPilotos = listaPilotos;
    }
}
