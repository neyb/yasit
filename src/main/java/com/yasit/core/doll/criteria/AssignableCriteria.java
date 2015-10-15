package com.yasit.core.doll.criteria;

import com.yasit.core.doll.definition.DollDefinition;

class AssignableCriteria<T> implements DollCriteria<T> {
    private final Class<T> dollClass;

    public AssignableCriteria(Class<T> dollClass) {
        this.dollClass = dollClass;
    }

    @Override
    public boolean matches(DollDefinition<?> definition) {
        return definition.isAssignableTo(dollClass);
    }
}
