package com.yasit.core;

import com.yasit.core.doll.scope.BuildtInScopes;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContextTest_Scopes extends ContextTestCommon{

    @Test
    public void whenAClassIsAddedAsPrototype_getWithObjectReturnsItAndCreateItEveryTimes() throws Exception {
        context.addDoll(InstanceCountedTest.class).in(BuildtInScopes.PROTOTYPE);
        Object t = context.getDoll(Object.class);
        assertNotNull(t);
        assertTrue(t instanceof InstanceCountedTest);
        assertNotSame(t, context.getDoll(Object.class));
    }

    @Test
    public void whenAClassIsAddedAsSingleton_getReturnsSameObject() throws Exception {
        context.addDoll(InstanceCountedTest.class).in(BuildtInScopes.SINGLETON);
        Object t = context.getDoll(Object.class);
        assertNotNull(t);
        assertTrue(t instanceof InstanceCountedTest);
        assertSame(t, context.getDoll(Object.class));
    }

    @Test
    public void whenAClassIsAddedAsDefault_getReturnsSameObject() throws Exception {
        context.addDoll(InstanceCountedTest.class);
        Object t = context.getDoll(Object.class);
        assertNotNull(t);
        assertTrue(t instanceof InstanceCountedTest);
        assertSame(t, context.getDoll(Object.class));
    }
}
