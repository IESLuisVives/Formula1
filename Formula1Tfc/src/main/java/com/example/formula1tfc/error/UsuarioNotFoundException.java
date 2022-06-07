package com.example.formula1tfc.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String id) {
        super("No se encuentra ningún usuario con la ID: " + id);
    }
}
