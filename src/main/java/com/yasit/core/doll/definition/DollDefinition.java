package com.yasit.core.doll.definition;

import com.yasit.core.doll.provider.DollProvider;
import com.yasit.core.doll.scope.Scope;

public interface DollDefinition<T> {
    boolean isAssignableTo(Class<?> dollClass);

    DollProvider<T> getProvider();

    Scope getScope();
}
