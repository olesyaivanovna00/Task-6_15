package com.company.tests;

import com.company.MyHashMap;

import java.util.Map;

public class MyHashMapCreator implements MapCreator {
    private int defaultCapacity;

    public MyHashMapCreator(int defaultCapacity) {

        this.defaultCapacity = defaultCapacity;
    }

    @Override
    public Map<String, Object> create() {

        return new MyHashMap<>(defaultCapacity);
    }
}
