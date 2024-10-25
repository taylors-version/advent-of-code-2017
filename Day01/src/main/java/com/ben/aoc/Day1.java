package com.ben.aoc;

import com.ben.aoc.collection.Collection;

import java.util.List;

public class Day1 {
    List<String> lines;

    public long puzzle1(String input) {
        List<String> pairs = Collection.sliding(input, 2);

        long result = 0;
        for(int i = 0; i<pairs.size(); i++){
            String pair = pairs.get(i);
            if(pair.charAt(0) == pair.charAt(1)){
                result += pair.charAt(0) - '0';
            }
        }

        int loopPair = input.charAt(0) == input.charAt(input.length() - 1) ? input.charAt(0) - '0' : 0;
        return result + loopPair;
    }

    public long puzzle2(String input) {
        List<String> pairs = Collection.sliding(input, 2);

        long result = 0;
        for(int i = 0; i<pairs.size(); i++){
            String pair = pairs.get(i);
            if(pair.charAt(0) == pair.charAt(1)){
                result += pair.charAt(0) - '0';
            }
        }

        int loopPair = input.charAt(0) == input.charAt(input.length() - 1) ? input.charAt(0) - '0' : 0;
        return result + loopPair;
    }
}
