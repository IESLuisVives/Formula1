package com.example.formula1tfc.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "login")
@NamedQuery(name = "login.findAll", query = "SELECT l FROM Login l")
public class Login {

    private String id;
    private String token;
    @ToString.Exclude
    private Usuario usuario;


    public Login(String token, Usuario usuario) {
        this.id = UUID.randomUUID().toString();
        this.token = token;
        this.usuario = usuario;
    }

    @Id
    @GeneratedValue
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}


/*
    @OneToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

 */
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {return token;}
    public void setToken(String token) {this.token = token;}

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
