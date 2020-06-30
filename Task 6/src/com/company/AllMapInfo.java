package com.company;


import com.company.generator.Generator;
import com.company.generator.MyGenerator;
import com.company.tests.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AllMapInfo {

    public static class AddTest implements ActionOnMap {
        @Override
        public MapInfo action(MapCreator mc, String[] keys, Object[] values) {
            int numOfEl = keys.length;
            Map<String, Object> MyTestMap = mc.create();

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < numOfEl; i++) {
                MyTestMap.put(keys[i], values[i]);
            }
            long finishTime = System.currentTimeMillis();

            return new MapInfo(numOfEl, finishTime - startTime);
        }
    }

    public static class DeleteTest implements ActionOnMap{
        @Override
        public MapInfo action(MapCreator mc, String[] keys, Object[] values) {
            int numOfEl = keys.length;
            Map<String, Object> javaTestMap = mc.create();
            for (int i = 0; i < numOfEl; i++) {
                javaTestMap.put(keys[i], values[i]);
            }

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < numOfEl; i++) {
                javaTestMap.remove(keys[i]);
            }
            long finishTime = System.currentTimeMillis();

            return new MapInfo(numOfEl, finishTime - startTime);
        }
    }

    public static class SearchTest implements ActionOnMap {
        @Override
        public MapInfo action(MapCreator mc, String[] keys, Object[] values) {
            int numOfEl = keys.length;
            Map<String, Object> javaTestMap = mc.create();
            for (int i = 0; i < numOfEl; i++) {
                javaTestMap.put(keys[i], values[i]);
            }

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < numOfEl; i++) {

                javaTestMap.get(keys[i]);
            }
            long finishTime = System.currentTimeMillis();

            return new MapInfo(numOfEl, finishTime - startTime);
        }
    }

    public static class AddAndDeleteTest implements ActionOnMap{
        @Override
        public MapInfo action(MapCreator mc, String[] keys, Object[] values) {
            int numOfEl = keys.length;
            Map<String, Object> javaTestMap = mc.create();

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < numOfEl; i++) {
                javaTestMap.remove(keys[i]);
            }
            for (int i = 0; i < numOfEl; i++) {
                javaTestMap.put(keys[i], values[i]);
            }


            long finishTime = System.currentTimeMillis();

            return new MapInfo(numOfEl, finishTime - startTime);
        }
    }



    public static ArrayList<MapInfo> buildPoints(String action, String dataType, int lenOfKey, int countOfEl){
        ArrayList<MapInfo> exp = new ArrayList<>();
        MyGenerator gen = new Generator();
        ArrayList<MapCreator> all = new ArrayList<>();
        all.add(new JavaHashMapCreator());
        all.add(new JavaTreeMapCreator());
        all.add(new MyHashMapCreator(countOfEl));
        all.add(new MyTreeMapCreator());


        String[] keys = gen.makeKey(lenOfKey, countOfEl);
        Integer[] valuesInt = gen.makeValueInt(countOfEl);
        Double[] valuesDouble = gen.makeValueDouble(countOfEl);

        HashMap<String, ActionOnMap> actions = new HashMap<>();
        actions.put("Add", new AddTest());
        actions.put("Delete", new DeleteTest());
        actions.put("Search", new SearchTest());
        actions.put("AddAndDelete", new AddAndDeleteTest());


        if (dataType.equals("Integer")) {
            for (int i = 0; i < 4; i++) {
                exp.add(actions.get(action).action(all.get(i), keys, valuesInt));
            }
        } else if (dataType.equals("Double")){
            for (int i = 0; i < 4; i++) {
                exp.add(actions.get(action).action(all.get(i), keys, valuesDouble));
            }
        }

        return exp;

    }

}




