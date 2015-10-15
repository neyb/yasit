package com.yasit.core.doll.criteria;

import com.yasit.core.doll.definition.DollDefinition;

public interface DollCriteria<T> {
    boolean matches(DollDefinition<?> definition);

    @SuppressWarnings("unchecked")
    default DollDefinition<? extends T> as(DollDefinition<?> definition) {
        return (DollDefinition<? extends T>) definition;
    }

    static <T> DollCriteria<? extends T> ofClass(Class<T> dollClass) {
        return new AssignableCriteria(dollClass);
    }
}
