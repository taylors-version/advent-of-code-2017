package com.ben.aoc;


import java.util.*;
import java.util.stream.IntStream;

public class Day13 {

    public long puzzle1(List<String> input) {
        Map<Integer, Integer> scanners = parseScanners(input);
        long sev = 0;

        for(var scanner : scanners.entrySet()){
            int repeat = (scanner.getValue()-1) * 2;
            if((scanner.getKey()) % repeat == 0) {
                sev += (long) scanner.getKey() * scanner.getValue();
            }
        }

        return sev;
    }

    public long puzzle2(List<String> input) {
        Map<Integer, Integer> scanners = parseScanners(input);
        int delay = -1;
        boolean caught = true;
        while(caught){
            delay++;
            caught = isCaught(scanners, delay);
        }

        return delay;
    }

    private Map<Integer, Integer> parseScanners(List<String> input){
        Map<Integer, Integer> scanners = new HashMap<>();

        for(String line : input){
            String[] split = line.split(": ");
            scanners.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        return scanners;
    }

    private boolean isCaught(Map<Integer, Integer> scanners, int delay){

        for(var scanner : scanners.entrySet()){
            int repeat = (scanner.getValue()-1) * 2;
            if((scanner.getKey() + delay) % repeat == 0) {
                return true;
            }
        }

        return false;
    }

}
