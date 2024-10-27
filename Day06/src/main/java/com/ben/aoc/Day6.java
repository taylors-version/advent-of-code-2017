package com.ben.aoc;

import java.util.*;

public class Day6 {

    public long puzzle1(String input) {
        int result = 0;
        List<Integer> memory = Arrays.stream(input.split("\\s")).map(Integer::parseInt).toList();

        Set<List<Integer>> seen = new HashSet<>();
        while(seen.add(memory)){
            result ++;
            memory = distribute(memory);
        }

        return result;
    }

    public long puzzle2(String input) {
        int result = 0;

        return result;
    }

    private List<Integer> distribute(List<Integer> memory){
        List<Integer> newMemory = new ArrayList<>(Collections.nCopies(memory.size(), 0));

        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < memory.size(); i++){
            if(memory.get(i) > max){
                max = memory.get(i);
                maxIndex = i;
            }
        }

        int toAdd = max / memory.size();
        int remainder = max % memory.size();

        for(int i = maxIndex + 1; i < maxIndex + memory.size(); i++){
            int additional = remainder > 0 ? 1 : 0;
            remainder--;
            int index = i % memory.size();
            newMemory.set(index, memory.get(index) + toAdd + additional);
        }
        newMemory.set(maxIndex, toAdd);

        return newMemory;
    }

}
