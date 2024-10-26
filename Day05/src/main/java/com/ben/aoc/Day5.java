package com.ben.aoc;


import java.util.ArrayList;
import java.util.List;


public class Day5 {

    public long puzzle1(List<String> input) {
        List<Integer> jumps = new ArrayList<>(input.stream().map(Integer::parseInt).toList());
        int result = 0;
        int index = 0;

        while (index < input.size()){
            result++;
            int value = jumps.get(index);
            int newIndex = index + value;
            jumps.set(index, value+1);
            index = newIndex;
        }

        return result;
    }

    public long puzzle2(List<String> input) {
        List<Integer> jumps = new ArrayList<>(input.stream().map(Integer::parseInt).toList());
        int result = 0;
        int index = 0;

        while (index < input.size()){
            result++;
            int value = jumps.get(index);
            int newIndex = index + value;
            int newValue = value >= 3 ? value - 1 : value + 1;
            jumps.set(index, newValue);
            index = newIndex;
        }

        return result;
    }

}
