package com.tecsup.petclinic.exception;

public class SpecialtyNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    public SpecialtyNotFoundException(String message) {
        super(message);
    }
}
