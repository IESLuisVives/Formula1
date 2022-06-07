package com.example.formula1tfc.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@EntityListeners(AuditingEntityListener.class)
@Builder
@Table(name = "usuario")
@NamedQuery(name = "usuario.findAll", query = "SELECT u FROM Usuario u")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Basic
    @Column(name = "correo")
    private String correo;

    @Basic
    @Column(name = "nombre")
    private String username;

    @Basic
    @Column(name = "contraseña")
    private String password;

    @Basic
    @Column(name = "imagen")
    private String imagen;

    @ToString.Exclude
    private Set<Login> login;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
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

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario", cascade = CascadeType.REMOVE)
    public Set<Login> getLogin() {
        return login;
    }

    public void setLogin(Set<Login> login) {
        this.login = login;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public Usuario(String id, String correo, String username, String password, String imagen, Set<UserRole> roles) {
        this.id = id;
        this.correo = correo;
        this.username = username;
        this.password = password;
        this.imagen = imagen;
        this.roles = roles;
    }
}
