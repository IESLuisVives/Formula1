package com.example.formula1tfc.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNameNotFoundException extends RuntimeException {
    public UsuarioNameNotFoundException(String nombre) {
        super("No se encuentra ningún usuario con nombre: " + nombre);
    }
}
