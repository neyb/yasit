package com.yasit.core;

import com.yasit.core.doll.scope.BuildtInScopes;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContextTest_Basic extends ContextTestCommon {

    @Test
    public void canCreateContext() throws Exception {
    }

    @Test
    public void canAddClass() throws Exception {
        context.addDoll(InstanceCounterTestClass.class);
    }

    @Test
    public void whenAClassIsAdded_getWithTheClassReturnsIt() throws Exception {
        context.addDoll(InstanceCounterTestClass.class);
        InstanceCounterTestClass t = context.getDoll(InstanceCounterTestClass.class);
        assertNotNull(t);
        assertEquals(1, InstanceCounterTestClass.i.get());
    }

    @Test
    public void whenAClassIsAdded_getWithObjectReturnsItAndCreateItEveryTimes() throws Exception {
        context.addDoll(InstanceCounterTestClass.class);
        Object t = context.getDoll(Object.class);
        assertNotNull(t);
        assertTrue(t instanceof InstanceCounterTestClass);
        assertNotSame(t, context.getDoll(Object.class));
    }

    @Test
    public void whenAClassIsAddedAsSingleton_getWithObjectReturnsItAndCreateItEveryTimes() throws Exception {
        context.addDoll(InstanceCounterTestClass.class).in(BuildtInScopes.SINGLETON);
        Object t = context.getDoll(Object.class);
        assertNotNull(t);
        assertTrue(t instanceof InstanceCounterTestClass);
        assertSame(t, context.getDoll(Object.class));
    }

}