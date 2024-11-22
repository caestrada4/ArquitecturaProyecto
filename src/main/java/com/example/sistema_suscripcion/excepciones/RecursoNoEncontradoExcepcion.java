package com.example.sistema_suscripcion.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Marca esta excepción para devolver un estado HTTP 404 (Not Found)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoExcepcion extends RuntimeException {

    public RecursoNoEncontradoExcepcion(String mensaje) {
        super(mensaje); // Pasamos el mensaje al constructor de RuntimeException
    }
}
