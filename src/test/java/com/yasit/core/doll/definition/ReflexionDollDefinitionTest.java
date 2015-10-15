package com.yasit.core.doll.definition;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReflexionDollDefinitionTest {

    @Test
    public void testIsAssignableTo() throws Exception {
        assertTrue(new ReflexionDollDefinition<>(String.class).isAssignableTo(Object.class));
        assertFalse(new ReflexionDollDefinition<>(Object.class).isAssignableTo(String.class));
    }

    @Test
    public void testGetProvider() throws Exception {
        assertNotNull(new ReflexionDollDefinition<>(Object.class).getProvider());
    }
}