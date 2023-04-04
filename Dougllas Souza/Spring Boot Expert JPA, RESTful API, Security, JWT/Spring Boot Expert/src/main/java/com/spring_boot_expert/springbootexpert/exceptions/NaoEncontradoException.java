package com.spring_boot_expert.springbootexpert.exceptions;

public class NaoEncontradoException extends RuntimeException {

    public NaoEncontradoException(String ex) {
        super(ex);
    }
}
