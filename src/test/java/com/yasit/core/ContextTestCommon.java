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
        InstanceCounterTestClass.i = new AtomicInteger(0);
    }

    protected static class InstanceCounterTestClass {
        protected static AtomicInteger i = new AtomicInteger(0);

        public InstanceCounterTestClass() {
            i.incrementAndGet();
        }
    }

}
