package com.minsait.LRU;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CacheLRUTest {

    @Test
    public void should_put_and_get_value() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);

        cache.put(1, "A");
        Object result = cache.get(1);

        assertEquals("A", result);
    }

    @Test
    public void should_evict_lru_key() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.get(1);

        cache.put(3, "C");

        assertEquals("A", cache.get(1));
        assertNull(cache.get(2));
        assertEquals("C", cache.get(3));
    }

    @Test
    public void should_return_null_when_key_not_found() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);

        Object result = cache.get(99);

        assertNull(result);
    }

    @Test
    public void should_update_existing_key() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);

        cache.put(1, "A");
        cache.put(2, "B");

        cache.put(1, "J");

        assertEquals("J", cache.get(1));
        assertEquals("B", cache.get(2));
    }
}
