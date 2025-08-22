package com.ben.aoc;


import java.util.ArrayList;
import java.util.List;

public class Day17 {

    public long puzzle1(String input) {
        List<Integer> buffer = new ArrayList<>();
        int adder = Integer.parseInt(input);
        buffer.add(0);
        int index = 0;

        for(int i = 1; i <= 2017; i++){
            index = (index + adder) % buffer.size();
            index++;
            buffer.add(index, i);

        }

        return buffer.get(index+1);
    }

    public long puzzle2(String input) {
        return 0;
    }


}
