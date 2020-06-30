package com.company.generator;

import java.util.Random;


public class Generator implements MyGenerator{

    private static Random rnd = new Random();

    @Override
    public String[] makeKey(int lenOfKey, int sizeOfArray) {
        String[] key = new String[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            key[i] = randomString(lenOfKey);
        }
        return key;
    }

    @Override
    public Integer[] makeValueInt(int sizeOfArray) {
        Integer[] value = new Integer[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            value[i] = randomInt(10000);
        }
        return value;
    }

    @Override
    public Double[] makeValueDouble(int sizeOfArray) {
        Double[] value = new Double[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            value[i] = randomDouble();
        }
        return value;
    }


    public static String randomString(int n) {
        // нижний предел для строчных букв
        int lowerLimit = 97;
        // нижний предел для строчных букв
        int upperLimit = 122;
        StringBuffer r = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            // принимаем случайное значение от 97 до 122
            int nextRandomChar = lowerLimit
                    + (int)(rnd.nextFloat()
                    * (upperLimit - lowerLimit + 1));
            // добавить символ в конце bs
            r.append((char)nextRandomChar);
        }
        return r.toString();
    }

    public static int randomInt(int max) {
        return rnd.nextInt((max - 0) + 1) + 0;
    }

    public static Double randomDouble() {
        return  Math.random() * 10000 - 0;
    }


}
