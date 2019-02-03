package com.azimka.chapter1_1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class SpyUsageTest {

    @Test
    public void testSpy() {
        Map<String, String> someMap = new HashMap<>();

        Map<String, String> hashMapSpy = spy(someMap);

        assertEquals(hashMapSpy.get("key"), null);

        hashMapSpy.put("key", "value");

        assertEquals(hashMapSpy.get("key"), "value");

        when(hashMapSpy.get("key")).thenReturn("another value");

        assertEquals(hashMapSpy.get("key"), "another value");
    }
}
