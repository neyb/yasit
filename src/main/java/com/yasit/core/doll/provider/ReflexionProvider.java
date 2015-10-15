package com.yasit.core.doll.provider;

import com.yasit.core.exceptions.cannotCreateDoll;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ReflexionProvider<T> implements DollProvider<T> {
    private final Class<T> dollClass;
    private Constructor<T> constructor;

    public ReflexionProvider(Class<T> dollClass) {
        this.dollClass = dollClass;
    }

    @Override
    public T get() {
        try {
            constructor = dollClass.getConstructor();
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new cannotCreateDoll(e);
        }
    }
}
