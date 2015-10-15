package com.yasit.core.doll.provider;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReflexionProviderTest {
    public static class TestClass {
        private static AtomicInteger instanceCounter = new AtomicInteger();

        public TestClass() {
            instanceCounter.incrementAndGet();
        }
    }

    @Before
    public void init() {
        TestClass.instanceCounter = new AtomicInteger();
    }

    @Test
    public void testGet() throws Exception {
        assertTrue(new ReflexionProvider<>(TestClass.class).get() != null);
        assertEquals(1, TestClass.instanceCounter.intValue());
        assertTrue(new ReflexionProvider<>(TestClass.class).get() != null);
        assertEquals(2, TestClass.instanceCounter.intValue());
    }
}