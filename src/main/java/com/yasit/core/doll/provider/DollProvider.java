package com.yasit.core.doll.provider;

public interface DollProvider<T> {
    static <T> DollProvider<T> of(Class<T> dollClass) {
        return new ReflexionProvider<>(dollClass);
    }

    T get();
}
