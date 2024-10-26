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

}
