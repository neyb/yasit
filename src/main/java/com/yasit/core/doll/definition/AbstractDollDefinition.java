package com.yasit.core.doll.definition;

import com.yasit.core.doll.provider.DollProvider;
import com.yasit.core.doll.scope.BuildtInScopes;
import com.yasit.core.doll.scope.Scope;

public abstract class AbstractDollDefinition<T> implements ModifiableDollDefinition<T> {
    private DollProvider<T> provider;
    private Scope scope = BuildtInScopes.PROTOTYPE;

    @Override
    public DollProvider<T> getProvider() {
        return provider;
    }

    @Override
    public Scope getScope() {
        return scope;
    }

    @Override
    public ModifiableDollDefinition in(Scope scope) {
        this.scope = scope;
        return this;
    }

    @Override
    public ModifiableDollDefinition with(DollProvider<T> provider) {
        this.provider = provider;
        return this;
    }
}
