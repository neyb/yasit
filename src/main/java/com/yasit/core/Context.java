package com.yasit.core;

import com.yasit.core.doll.criteria.DollCriteria;
import com.yasit.core.doll.definition.ModifiableDollDefinition;

public class Context {

    private final DollDefinitions definitions = new DollDefinitions();
    private final Dolls dolls = new Dolls(definitions);

    public <T> ModifiableDollDefinition<T> addDoll(Class<T> dollClass) {
        return definitions.addDollClass(dollClass);
    }

    public <T> T getDoll(Class<T> dollClass) {
        return dolls.getOrCreateDoll(DollCriteria.ofClass(dollClass));
    }
}
