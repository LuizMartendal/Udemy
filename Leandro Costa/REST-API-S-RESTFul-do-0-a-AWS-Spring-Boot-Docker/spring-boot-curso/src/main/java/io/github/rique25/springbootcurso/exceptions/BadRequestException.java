package io.github.rique25.springbootcurso.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    BadRequestException(String message) {
        super(message);
    }
}
