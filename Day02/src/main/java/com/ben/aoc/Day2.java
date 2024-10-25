package com.ben.aoc;
import java.util.List;

public class Day2 {

    public long puzzle1(List<String> lines) {
        int result = 0;
        for(String line: lines){
            String[] numbers = line.split("\\D+");
            int max = 0;
            int min = Integer.MAX_VALUE;
            for(String number: numbers){
                int val = Integer.parseInt(number);
                if (val < min)
                    min = val;
                if (val > max)
                    max = val;
            }
            result += (max - min);
        }

        return result;
    }

}
