package com.yasit.core.doll.definition;

import com.yasit.core.doll.provider.DollProvider;
import com.yasit.core.doll.provider.ReflexionProvider;

public class ReflexionDollDefinition<T> implements DollDefinition<T> {

    private final Class<T> dollClass;
    private final DollProvider<T> provider;

    public ReflexionDollDefinition(Class<T> dollClass) {
        this.dollClass = dollClass;
        provider = new ReflexionProvider<>(dollClass);
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
