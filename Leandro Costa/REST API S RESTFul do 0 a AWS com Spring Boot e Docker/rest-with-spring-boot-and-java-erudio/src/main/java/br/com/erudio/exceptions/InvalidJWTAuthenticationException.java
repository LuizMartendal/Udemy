package br.com.erudio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJWTAuthenticationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidJWTAuthenticationException(String error) {
        super(error);
    }
}
