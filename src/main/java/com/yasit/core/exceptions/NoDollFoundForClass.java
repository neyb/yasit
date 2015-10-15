package com.yasit.core.exceptions;

public class NoDollFoundForClass extends RuntimeException {
    public NoDollFoundForClass(Class<?> dollClass) {
        super(String.format("no doll found for class %s", dollClass.getName()));
    }
}
