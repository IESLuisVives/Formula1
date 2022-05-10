package com.example.formula1tfc.models;

import com.example.formula1tfc.configuration.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@NoArgsConstructor
public abstract class Usuario {

    @JsonView({Views.Admin.class, Views.Cliente.class})
    private UUID id;
    @JsonView({Views.Admin.class, Views.Cliente.class})
    private String nombre;
    @JsonView({Views.Admin.class, Views.Cliente.class})
    private String email;
    @JsonView({Views.Admin.class, Views.Cliente.class})
    private String password;
    @JsonView({Views.Admin.class, Views.Cliente.class})
    private String foto;
    /*@JsonView({Views.Admin.class, Views.Cliente.class})
    private Login login;*/

    public Usuario(String nombre, String email, String password, String foto) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.foto = foto;
        id = UUID.randomUUID();
    }

    //TEST
    public Usuario(UUID id, String nombre, String correo, String password, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.email = correo;
        this.password = password;
        this.foto = foto;
    }

    @Id
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    public String getCorreo() {
        return email;
    }

    public void setCorreo(String corre) {
        this.email = corre;
    }

    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    /*@Embedded
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }*/
}

