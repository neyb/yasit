package com.yasit.core;

import com.yasit.core.doll.provider.DollProvider;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ContextTest_Provider extends ContextTestCommon {
    @Test
    public void whenUsingProvider_instanceShouldBeCreateThroughtThisProviderOnly() throws Exception {
        @SuppressWarnings("unchecked")
        DollProvider<InstanceCountedTest> provider = mock(DollProvider.class);
        when(provider.get()).then(invocation -> new InstanceCountedTest());

        context.addDoll(InstanceCountedTest.class).with(provider);
        InstanceCountedTest doll = context.getDoll(InstanceCountedTest.class);

        verify(provider, times(1)).get();
        assertEquals(1, InstanceCountedTest.instanceCounter.get());
    }
}