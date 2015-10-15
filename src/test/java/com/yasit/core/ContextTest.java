package com.yasit.core;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class ContextTest {

    private Context context = new Context();

    @Before
    public void initCounter() {
        TestClass.i = new AtomicInteger(0);
    }

    @Before
    public void initContext() {
        context = new Context();
    }

    @Test
    public void canCreateContext() throws Exception {
    }

    @Test
    public void canAddClass() throws Exception {
        context.addDoll(TestClass.class);
    }

    @Test
    public void whenAClassIsAdded_getWithTheClassReturnsIt() throws Exception {
        context.addDoll(TestClass.class);
        TestClass t = context.getDoll(TestClass.class);
        assertNotNull(t);
        assertEquals(1, TestClass.i.get());
    }

    @Test
    public void whenAClassIsAdded_getWithObjectReturnsItAndCreateItOnlyOnce() throws Exception {
        context.addDoll(TestClass.class);
        Object t = context.getDoll(Object.class);
        assertNotNull(t);
        assertTrue(t instanceof TestClass);
    }

    public static class TestClass {
        private static AtomicInteger i = new AtomicInteger(0);

        public TestClass() {
            i.incrementAndGet();
        }
    }

}