package com.yasit.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContextTest_Basic extends ContextTestCommon {

    @Test
    public void canCreateContext() throws Exception {
    }

    @Test
    public void canAddClass() throws Exception {
        context.addDoll(InstanceCountedTest.class);
    }

    @Test
    public void whenAClassIsAdded_getWithTheClassReturnsIt() throws Exception {
        context.addDoll(InstanceCountedTest.class);
        InstanceCountedTest t = context.getDoll(InstanceCountedTest.class);
        assertNotNull(t);
        assertEquals(1, InstanceCountedTest.instanceCounter.get());
    }

}