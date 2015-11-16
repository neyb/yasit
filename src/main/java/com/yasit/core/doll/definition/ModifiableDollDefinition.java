package com.yasit.core.doll.definition;

import com.yasit.core.doll.provider.DollProvider;
import com.yasit.core.doll.scope.Scope;

public interface ModifiableDollDefinition<T> extends DollDefinition<T> {
    ModifiableDollDefinition in(Scope scope);

    ModifiableDollDefinition with(DollProvider<T> provider);
}
