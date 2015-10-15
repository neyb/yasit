package com.yasit.core.doll.definition;

import com.yasit.core.doll.provider.DollProvider;

public interface DollDefinition<T> {
    static <T> DollDefinition<T> of(Class<T> dollClass) {
        return new ReflexionDollDefinition<>(dollClass);
    }

    boolean isAssignableTo(Class<?> dollClass);

    DollProvider<T> getProvider();
}
