package com.ben.aoc;


import java.util.*;
import java.util.stream.IntStream;

public class Day13 {

    public long puzzle1(List<String> input) {
        Map<Integer, Integer> scanners = new HashMap<>();
        long sev = 0;

        for(String line : input){
            String[] split = line.split(": ");
            scanners.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }

        for(var scanner : scanners.entrySet()){
            int repeat = (scanner.getValue()-1) * 2;
            if(scanner.getKey() % repeat == 0) {
                sev += (long) scanner.getKey() * scanner.getValue();
            }
        }

        return sev;
    }

    public long puzzle2(List<String> input) {
        return 0;
    }

    private int posAtTime(int time, int range){
        return 0;
    }

}
