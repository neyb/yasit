package com.yasit.core.doll.definition;

import com.yasit.core.doll.provider.DollProvider;

public interface DollDefinition<T> {
    boolean isAssignableTo(Class<?> dollClass);
    DollProvider<T> getProvider();
}
