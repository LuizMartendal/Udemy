package com.spring_boot_expert.springbootexpert.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(NaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleRegraNegocioException(NaoEncontradoException ex) {
        return new ApiErrors(ex.getMessage());
    }

    @ExceptionHandler(IsNullException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleIsNullException(IsNullException ex) {
        return new ApiErrors(ex.getMessage());
    }

}
