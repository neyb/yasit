package com.yasit.core.doll.criteria;

import com.yasit.core.doll.definition.DollDefinition;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssignableCriteriaTest {

    @Test
    public void ObjectCriteriaMatchesString() throws Exception {
        assertTrue(new AssignableCriteria<>(Object.class).matches(DollDefinition.of(String.class)));
    }

    @Test
    public void StringCriteriaDoesNotMatchObject() throws Exception {
        assertFalse(new AssignableCriteria<>(String.class).matches(DollDefinition.of(Object.class)));
    }
}