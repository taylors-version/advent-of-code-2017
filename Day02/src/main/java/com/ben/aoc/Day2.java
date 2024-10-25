package com.ben.aoc;
import com.ben.aoc.collection.Collection;

import java.util.Arrays;
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

    public long puzzle2(List<String> lines) {
        int result = 0;

        for(String line: lines){
            List<String> numbers = Arrays.stream(line.split("\\D+")).toList();
            List<List<String>> pairs = Collection.combinationsUtil(numbers, 2);
            for(List<String> pair : pairs){
                int left = Integer.parseInt(pair.get(0));
                int right = Integer.parseInt(pair.get(1));
                int numerator = Math.max(left, right);
                int denominator = Math.min(left, right);

                if((numerator / denominator) * denominator == numerator){
                    result += (numerator / denominator);
                }
            }

        }

        return result;
    }

}
