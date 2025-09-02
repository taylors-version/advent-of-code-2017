package com.ben.aoc;

import java.util.*;

public class Day25 {

    public long puzzle1(List<String> input) {
        Map<Character, State> states = new HashMap<>();
        Map<Integer, Boolean> tape = new HashMap<>();
        int headPos = 0;
        int steps = Integer.parseInt(input.get(1).replaceAll("[^0-9]", ""));

        for(int i = 3; i < input.size(); i+=10){
            boolean falseWrite = input.get(i+2).charAt(22) == '1';
            int falseDir = input.get(i+3).charAt(27) == 'r' ? 1 : -1;
            char falseState = input.get(i+4).charAt(26);
            boolean trueWrite = input.get(i+6).charAt(22) == '1';
            int trueDir = input.get(i+7).charAt(27) == 'r' ? 1 : -1;
            char trueState = input.get(i+8).charAt(26);
            State state = new State(falseWrite, trueWrite, falseDir, trueDir, falseState, trueState);
            states.put(input.get(i).charAt(9), state);
        }

        State state = states.get('A');

        for(int i = 0; i < steps; i++){
            boolean readValue = tape.getOrDefault(headPos, false);
            tape.put(headPos, state.getPrint(readValue));
            headPos += state.getDirection(readValue);
            state = states.get(state.getNext(readValue));
        }

        int ones = 0;
        for(Boolean b: tape.values()){
            if (b){
                ones++;
            }
        }
        return ones;
    }

    public String puzzle2(List<String> input) {
        return "Merry Christmas";
    }

}
