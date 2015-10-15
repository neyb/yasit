package com.yasit.core;

public class Context {

    private final DollDefinitions definitions = new DollDefinitions();

    public void addDoll(Class<?> dollClass) {
        definitions.addDollClass(dollClass);
    }

    public <T> T getDoll(Class<T> dollClass) {
        return definitions.getSingleEligibleDefinitionsFor(dollClass).getProvider().get();
    }
}
