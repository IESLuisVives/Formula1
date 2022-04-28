package com.example.formula1tfc.models;


import com.example.formula1tfc.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class Cliente extends Usuario {

    public Cliente(UUID id, String nombre, String correo, String password, String foto) {
        super(id, nombre, correo, password, foto);
    }

}
