package com.company;

import com.company.tests.MapCreator;

public interface ActionOnMap {

        MapInfo action(MapCreator mc, String[] keys, Object[] values);

}
