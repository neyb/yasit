package com.yasit.core;

import com.yasit.core.doll.criteria.DollCriteria;
import com.yasit.core.doll.definition.DollDefinition;
import com.yasit.core.doll.scope.BuildtInScopes;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Dolls {
    private final Map<DollDefinition<?>, Object> dolls = new HashMap<>();
    private final DollDefinitions definitions;

    public Dolls(DollDefinitions definitions) {
        this.definitions = definitions;
    }

    @SuppressWarnings("unchecked")
    public <T> Optional<T> getDoll(DollCriteria<T> criteria) {
        return Optional.ofNullable((T)
                dolls.get(definitions.getSingleEligibleDefinitionsFor(criteria)));
    }

    public <T> T getOrCreateDoll(DollCriteria<T> dollCriteria) {
        return getDoll(dollCriteria).orElseGet(() -> createNewDoll(dollCriteria));
    }

    private <T> T createNewDoll(DollCriteria<T> dollCriteria) {
        DollDefinition<? extends T> dollDefinition = definitions.getSingleEligibleDefinitionsFor(dollCriteria);
        T newDoll = dollDefinition.getProvider().get();
        if (dollDefinition.getScope() != BuildtInScopes.PROTOTYPE) dolls.put(dollDefinition, newDoll);
        return newDoll;
    }
}
