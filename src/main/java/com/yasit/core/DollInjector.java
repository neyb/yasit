package com.yasit.core;

import com.yasit.core.doll.criteria.DollCriteria;
import com.yasit.core.doll.definition.DollDefinition;
import com.yasit.core.doll.provider.DollProvider;

public class DollInjector {

    private final Dolls dollsBeingInjected;

    public DollInjector(DollDefinitions definitions) {
        dollsBeingInjected = new Dolls(definitions);
    }

    public <T> T get(DollCriteria<T> dollCriteria, Dolls dolls, DollDefinitions dollDefinitions) {
        return dolls.getDoll(dollCriteria).orElseGet(() ->
                createDoll(dollCriteria, dolls, dollDefinitions));
    }

    private <T> T createDoll(DollCriteria<T> dollCriteria, Dolls dolls, DollDefinitions dollDefinitions) {
        DollDefinition<? extends T> dollDefinition = dollDefinitions.getSingleEligibleDefinitionsFor(dollCriteria);
        T newDoll;
        synchronized (dollDefinition) {
            DollProvider<? extends T> provider = dollDefinition.getProvider();
            newDoll = provider.get();
        }
        return newDoll;
    }
}
