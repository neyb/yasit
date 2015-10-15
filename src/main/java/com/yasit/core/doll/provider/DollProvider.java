package com.yasit.core.doll.provider;

public interface DollProvider<T> {
    T get();

    static <T> DollProvider<T> of(Class<T> dollClass) {
        return new ReflexionProvider<>(dollClass);
    }
}
