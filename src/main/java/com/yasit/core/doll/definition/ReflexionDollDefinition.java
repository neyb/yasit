package com.yasit.core.doll.definition;

import com.yasit.core.doll.provider.DollProvider;

class ReflexionDollDefinition<T> extends AbstractDollDefinition<T> {

    private final Class<T> dollClass;

    public ReflexionDollDefinition(Class<T> dollClass) {
        this.dollClass = dollClass;
        with(DollProvider.of(dollClass));
    }

    @Override
    public boolean isAssignableTo(Class<?> dollClass) {
        return dollClass.isAssignableFrom(this.dollClass);
    }
}
