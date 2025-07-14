package com.minsait;

import com.minsait.LRU.CacheLRU;

public class Main {
    public static void main(String[] args) {
        CacheLRU<Integer, String> cache = new CacheLRU<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.get(1);
        cache.put(4, "Four");

        cache.print();
    }
}