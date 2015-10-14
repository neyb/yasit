package com.yasit.core;

public class ObjectDefinition<T> {
    private final Class<T> objectClass;

    public ObjectDefinition(Class<T> objectClass) {
        this.objectClass = objectClass;
    }
}
