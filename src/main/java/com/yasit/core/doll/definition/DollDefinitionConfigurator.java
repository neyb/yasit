package com.yasit.core.doll.definition;

import com.yasit.core.doll.provider.DollProvider;
import com.yasit.core.doll.scope.Scope;

public class DollDefinitionConfigurator<T> {
    private final ModifiableDollDefinition<T> dollDefinition;

    DollDefinitionConfigurator(ModifiableDollDefinition<T> dollDefinition) {
        this.dollDefinition = dollDefinition;
    }

    public DollDefinitionConfigurator<T> in(Scope scope) {
        dollDefinition.setScope(scope);
        return this;
    }
    public DollDefinitionConfigurator<T> with(DollProvider<T> provider) {
        dollDefinition.setProvider(provider);
        return this;
    }

}
