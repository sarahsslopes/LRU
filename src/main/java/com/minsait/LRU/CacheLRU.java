package com.minsait.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheLRU<K, V> {
    private final int capacity;
    private final Map<K, V> map;

    public CacheLRU(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<K, V>(capacity, 0.75f, true) {

            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > CacheLRU.this.capacity;
            }
        };
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.getOrDefault(key, null);
    }

    public int size() {
        return map.size();
    }

    public void print() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}