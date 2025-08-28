package com.ben.aoc;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day18 {
    Map<Character, Long> registers;

    public long puzzle1(List<String> input) {
        registers = new HashMap<>();
        long lastFrequency = 0;
        boolean recovered = false;
        int i = 0;
        while(!recovered){
            String[] line = input.get(i).split(" ");
            i++;
            switch (line[0]){
                case "snd":
                    lastFrequency = getValue(line[1]);
                    break;
                case "set":
                    registers.put(line[1].charAt(0), getValue(line[2]));
                    break;
                case "add":
                    add(line);
                    break;
                case "mul":
                    mul(line);
                    break;
                case "mod":
                    mod(line);
                    break;
                case "rcv":
                    recovered = getValue(line[1]) != 0;
                    break;
                case "jgz":
                    if(getValue(line[1]) > 0){
                        i+= (int) (getValue(line[2]) - 1);
                    }
            }
        }

        return lastFrequency;
    }

    public long puzzle2(List<String> input) {
        return 0;
    }

    private long getValue(String val){
        if(val.charAt(0) < 58){
            return Long.parseLong(val);
        }else {
            return registers.getOrDefault(val.charAt(0), 0L);
        }
    }

    private void add(String[] addOp){
        char location = addOp[1].charAt(0);
        long value = getValue(addOp[2]);
        registers.merge(location, value, Long::sum);
    }

    private void mul(String[] mulOp){
        char location = mulOp[1].charAt(0);
        long value = getValue(mulOp[2]);
        registers.computeIfPresent(location, (a, b) -> b * value);
    }

    private void mod(String[] modOp){
        char location = modOp[1].charAt(0);
        long value = getValue(modOp[2]);
        registers.computeIfPresent(location, (a, b) -> b % value);
    }

}
