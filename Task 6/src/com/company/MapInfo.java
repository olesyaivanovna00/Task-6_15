package com.company;

public class MapInfo {
    private int elCount;
    private long timeMs;

    public MapInfo(int elCount, long timeMs){
        this.elCount = elCount;
        this.timeMs = timeMs;
    }

    public int getElCount(){
        return elCount;
    }

    public long getTimeMs() {
        return timeMs;
    }
}
