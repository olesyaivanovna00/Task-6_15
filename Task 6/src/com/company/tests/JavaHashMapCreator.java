package com.company.tests;


import java.util.HashMap;
import java.util.Map;

public class JavaHashMapCreator implements MapCreator {


    @Override
    public Map<String, Object> create() {

        return new HashMap<>();
    }
}
