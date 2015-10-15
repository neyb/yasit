package com.yasit.core.doll.criteria;

import com.yasit.core.doll.definition.DollDefinition;

class AssignableCriteria implements DollCriteria {
    private final Class<?> dollClass;

    public AssignableCriteria(Class<?> dollClass) {
        this.dollClass = dollClass;
    }

    @Override
    public boolean matches(DollDefinition definition) {
        return definition.isAssignableTo(dollClass);
    }
}
