package com.yasit.core.doll.definition;

import com.yasit.core.doll.criteria.DollCriteria;
import com.yasit.core.doll.definition.DollDefinition;
import com.yasit.core.doll.definition.ModifiableDollDefinition;
import com.yasit.core.exceptions.NoDollFoundForCriteria;
import com.yasit.core.exceptions.severalDollFound;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DollDefinitions {
    private final Set<DollDefinition<?>> definitions = new HashSet<>();

    public <T> DollDefinition<? extends T> getSingleEligibleDefinitionsFor(DollCriteria<T> criteria) {
        Set<DollDefinition<? extends T>> eligibleDefinitions = getEligibleDefinitionsFor(criteria);
        if (eligibleDefinitions.isEmpty()) throw new NoDollFoundForCriteria(criteria);
        if (eligibleDefinitions.size() > 1) throw new severalDollFound(criteria);
        return eligibleDefinitions.iterator().next();
    }

    public <T> Set<DollDefinition<? extends T>> getEligibleDefinitionsFor(DollCriteria<T> criteria) {
        return definitions.stream()
                .filter(criteria::matches)
                .map(criteria::as)
                .collect(Collectors.toSet());
    }

    public <T> DollDefinitionConfigurator<T> addDollClass(Class<T> dollClass) {
        ModifiableDollDefinition<T> dollDefinition = DollDefinition.of(dollClass);
        definitions.add(dollDefinition);
        return new DollDefinitionConfigurator<>(dollDefinition);
    }
}
