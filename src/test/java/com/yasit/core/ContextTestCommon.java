package com.yasit.core;

import org.junit.Before;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ContextTestCommon {

    protected Context context = new Context();

    @Before
    public void initContext() {
        context = new Context();
    }

    @Before
    public void initCounter() {
        InstanceCountedTest.instanceCounter = new AtomicInteger(0);
    }

    protected static class InstanceCountedTest {
        protected static AtomicInteger instanceCounter = new AtomicInteger(0);

        public InstanceCountedTest() {
            instanceCounter.incrementAndGet();
        }
    }

}
