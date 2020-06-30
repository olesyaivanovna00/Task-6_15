package com.company.tests;

import com.company.myTreeMap.MyTreeMap;

import java.util.Map;

public class MyTreeMapCreator implements MapCreator {


    @Override
    public Map<String, Object> create() {

        return new MyTreeMap<>();
    }
}