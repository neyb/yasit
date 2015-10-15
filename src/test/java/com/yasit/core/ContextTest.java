package com.yasit.core;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class ContextTest {

    public static class TestClass {
        private static AtomicInteger i = new AtomicInteger(0);

        public TestClass() {
            i.incrementAndGet();
        }
    }

    @Before
    public void initCounter() {
        TestClass.i = new AtomicInteger(0);
    }

    @Test
    public void canCreateContext() throws Exception {
        new Context();
    }

    @Test
    public void canAddClass() throws Exception {
        new Context().addDoll(TestClass.class);
    }

    @Test
    public void whenAClassIsAdded_getWithTheClassReturnsIt() throws Exception {
        Context context = new Context();
        context.addDoll(TestClass.class);
        TestClass t = context.getDoll(TestClass.class);
        assertNotNull(t);
        assertEquals(1, TestClass.i.get());
    }

    @Test
    public void whenAClassIsAdded_getWithObjectReturnsItAndCreateItOnlyOnce() throws Exception {
        Context context = new Context();
        context.addDoll(TestClass.class);
        Object t = context.getDoll(Object.class);
        assertNotNull(t);
        assertTrue(t instanceof TestClass);
    }

}