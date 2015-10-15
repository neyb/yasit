package com.yasit.core.doll.provider;

import com.yasit.core.exceptions.cannotCreateDoll;

import java.lang.reflect.InvocationTargetException;

public class ReflexionProvider<T> implements DollProvider<T> {
    private final Class<T> dollClass;

    public ReflexionProvider(Class<T> dollClass) {
        this.dollClass = dollClass;
    }

    @Override
    public T get() {
        try {
            return dollClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new cannotCreateDoll(e);
        }
    }
}
