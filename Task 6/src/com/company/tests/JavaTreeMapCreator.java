package com.company.tests;

import java.util.Map;
import java.util.TreeMap;

public class JavaTreeMapCreator implements MapCreator {

    @Override
    public Map<String, Object> create() {

        return new TreeMap<>();
    }
}