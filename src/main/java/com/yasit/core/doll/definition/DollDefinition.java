package com.yasit.core.doll.definition;

import com.yasit.core.doll.provider.DollProvider;
import com.yasit.core.doll.scope.Scope;

public interface DollDefinition<T> {
    static <T> ReflexionDollDefinition<T> of(Class<T> dollClass) {
        return new ReflexionDollDefinition<>(dollClass);
    }

    boolean isAssignableTo(Class<?> dollClass);

    DollProvider<T> getProvider();

    Scope getScope();
}
