package com.yasit.core.doll.criteria;

import com.yasit.core.doll.definition.DollDefinition;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AssignableCriteriaTest {

    @Test
    public void ObjectCriteriaMatchesString() throws Exception {
        DollDefinition<String> dollDefinition = getDollDefinition(String.class);

        assertTrue(new AssignableCriteria<>(Object.class).matches(dollDefinition));
    }

    @Test
    public void StringCriteriaDoesNotMatchObject() throws Exception {
        DollDefinition<Object> dollDefinition = getDollDefinition(Object.class);

        assertFalse(new AssignableCriteria<>(String.class).matches(dollDefinition));
    }

    private <T> DollDefinition<T> getDollDefinition(Class<T> targetClass) {
        @SuppressWarnings("unchecked")
        DollDefinition<T> dollDefinition = Mockito.mock(DollDefinition.class);
        ArgumentCaptor<Class> captor = ArgumentCaptor.forClass(Class.class);
        Mockito.when(dollDefinition.isAssignableTo(captor.capture())).then(invocation -> captor.getValue().isAssignableFrom(targetClass));
        return dollDefinition;
    }
}