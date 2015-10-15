package com.yasit.core.doll.definition;

import com.yasit.core.doll.provider.DollProvider;

class ReflexionDollDefinition<T> implements DollDefinition<T> {

    private final Class<T> dollClass;
    private final DollProvider<T> provider;

    public ReflexionDollDefinition(Class<T> dollClass) {
        this.dollClass = dollClass;
        provider = DollProvider.of(dollClass);
    }

    @Override
    public boolean isAssignableTo(Class<?> dollClass) {
        return dollClass.isAssignableFrom(this.dollClass);
    }

    @Override
    public DollProvider<T> getProvider() {
        return provider;
    }
}
