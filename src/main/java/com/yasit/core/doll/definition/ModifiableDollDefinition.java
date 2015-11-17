package com.yasit.core.doll.definition;

import com.yasit.core.doll.provider.DollProvider;
import com.yasit.core.doll.scope.Scope;

interface ModifiableDollDefinition<T> extends DollDefinition<T> {
    void setScope(Scope scope);

    void setProvider(DollProvider<T> provider);
}
