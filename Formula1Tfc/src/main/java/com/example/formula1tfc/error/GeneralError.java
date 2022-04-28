package com.example.formula1tfc.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeneralError extends RuntimeException {
    public GeneralError() {
        super("Vaya, parece que ha habido un error.");
    }
}
