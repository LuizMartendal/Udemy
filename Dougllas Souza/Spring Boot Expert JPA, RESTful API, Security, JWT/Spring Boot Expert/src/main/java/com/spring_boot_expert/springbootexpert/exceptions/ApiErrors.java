package com.spring_boot_expert.springbootexpert.exceptions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApiErrors {

    public List<String> errors;

    public ApiErrors(String msg) {
        this.errors = Collections.singletonList(msg);
    }

    public List<String> getErrors() {
        return this.errors;
    }
}
