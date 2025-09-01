package com.ben.aoc;


import java.util.*;

public class Day23 {

    public long puzzle1(List<String> input) {
        Map<Character, Long> registers = new HashMap<>();
        long mulCount = 0;
        int i = 0;
        while(i >= 0 && i < input.size()){
            String[] line = input.get(i).split(" ");
            i++;
            switch (line[0]){
                case "set":
                    registers.put(line[1].charAt(0), getValue(registers, line[2]));
                    break;
                case "sub":
                    sub(registers, line);
                    break;
                case "mul":
                    mul(registers, line);
                     mulCount++;
                    break;
                case "jnz":
                    if(getValue(registers, line[1]) != 0){
                        i+= (int) (getValue(registers, line[2]) - 1);
                    }
            }
        }

        return mulCount;
    }

    public long puzzle2(List<String> input) {
        return 0;
    }

    private long getValue(Map<Character, Long> registers, String val){
        if(val.charAt(0) < 58){
            return Long.parseLong(val);
        }else {
            return registers.getOrDefault(val.charAt(0), 0L);
        }
    }

    private void sub(Map<Character, Long> registers, String[] addOp){
        char location = addOp[1].charAt(0);
        long value = -1 * getValue(registers, addOp[2]);
        registers.merge(location, value, Long::sum);
    }

    private void mul(Map<Character, Long> registers, String[] mulOp){
        char location = mulOp[1].charAt(0);
        long value = getValue(registers, mulOp[2]);
        registers.computeIfPresent(location, (a, b) -> b * value);
    }

}
