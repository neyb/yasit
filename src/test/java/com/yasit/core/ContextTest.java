package com.yasit.core;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        new Context().addClass(TestClass.class);
    }

    @Test
    public void whenAClassIsAdded_getWithTheClassReturnsIt() throws Exception {
        Context context = new Context();
        context.addClass(TestClass.class);
        TestClass t = context.get(TestClass.class);
        assertNotNull(t);
        assertEquals(1, TestClass.i.get());
    }

    @Test
    @Ignore
    public void whenAClassIsAdded_getWithObjectReturnsIt() throws Exception {
        Context context = new Context();
        context.addClass(TestClass.class);
        Object t = context.get(Object.class);
        assertNotNull(t);
        assertEquals(1, TestClass.i.get());
    }

}