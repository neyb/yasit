package com.yasit.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContextTest_Basic extends ContextTestCommon {

    @Test
    public void canCreateContext() throws Exception {
    }

    @Test
    public void canAddClass() throws Exception {
        context.addDoll(instanceCounterTestClass.class);
    }

    @Test
    public void whenAClassIsAdded_getWithTheClassReturnsIt() throws Exception {
        context.addDoll(instanceCounterTestClass.class);
        instanceCounterTestClass t = context.getDoll(instanceCounterTestClass.class);
        assertNotNull(t);
        assertEquals(1, instanceCounterTestClass.i.get());
    }

    @Test
    public void whenAClassIsAdded_getWithObjectReturnsItAndCreateItOnlyOnce() throws Exception {
        context.addDoll(instanceCounterTestClass.class);
        Object t = context.getDoll(Object.class);
        assertNotNull(t);
        assertTrue(t instanceof instanceCounterTestClass);
    }

}