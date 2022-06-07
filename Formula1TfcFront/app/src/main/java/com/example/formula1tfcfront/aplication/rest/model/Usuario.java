package com.example.formula1tfcfront.aplication.rest.model;

import java.util.Set;
import java.util.UUID;

public class Usuario {
    private String id;
    private String username;
    private String correo;
    private String password;
    private String imagen;
    private Set<UserRoles> roles;
    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Set<UserRoles> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRoles> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usuario() {
    }

    public Usuario( String username, String correo, String password, String imagen, Set<UserRoles> roles, String token) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.correo = correo;
        this.password = password;
        this.imagen = imagen;
        this.roles = roles;
        this.token = token;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", imagen='" + imagen + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
