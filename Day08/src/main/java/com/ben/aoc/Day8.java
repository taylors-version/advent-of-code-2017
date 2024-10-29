package com.ben.aoc;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Day8 {
    Map<String, Integer> registers = new HashMap<>();

    public long puzzle1(List<String> input) {

        parseInstructions(input);

        int result = Integer.MIN_VALUE;
        for(Integer register : registers.values()){
            result = Math.max(result, register);
        }

        return result;
    }

    public long puzzle2(List<String> input) {
        registers = new HashMap<>();
        return parseInstructions(input);
    }

    private int parseInstructions(List<String> instructions) {
        int max = Integer.MIN_VALUE;
        for (String instruction : instructions) {
            String[] split = instruction.split(" ");
            String register = split[0];
            Integer oldValue = registers.getOrDefault(register, 0);
            Integer addition = split[1].equals("inc") ? Integer.parseInt(split[2]) : Integer.parseInt(split[2]) * -1;

            boolean add = false;
            Integer comparedReg = registers.getOrDefault(split[4], 0);
            Integer comparedVal = Integer.parseInt(split[6]);
            switch (split[5]) {
                case ">":
                    add = comparedReg > comparedVal;
                    break;
                case ">=":
                    add = comparedReg >= comparedVal;
                    break;
                case "<":
                    add = comparedReg < comparedVal;
                    break;
                case "<=":
                    add = comparedReg <= comparedVal;
                    break;
                case "==":
                    add = comparedReg.equals(comparedVal);
                    break;
                case "!=":
                    add = !Objects.equals(comparedReg, comparedVal);
            }
            int newValue = add ? oldValue + addition : oldValue;
            max = Math.max(max, newValue);
            registers.put(register, newValue);
        }
        return max;
    }

}
