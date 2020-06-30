package com.company.generator;

public interface MyGenerator {

    String[] makeKey(int lenOfKey, int sizeOfArray);
    Integer[] makeValueInt(int sizeOfArray);
    Double[] makeValueDouble(int sizeOfArray);


}
