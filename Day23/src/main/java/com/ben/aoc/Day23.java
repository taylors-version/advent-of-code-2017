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

        return countComposites(107900,107900+17000, 17); // values came from initial b, initial c, the addition to b near the end
    }

    private long countComposites(int start, int end, int step){
        long count = 0;
        for(int i = start; i <= end; i+=step){
            if(isComposite(i)){
                count++;
            }
        }

        return count;
    }

    private boolean isComposite(int n){
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++){
            if(n%i == 0){
                return true;
            }
        }
        return false;
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

    private void printRegisters(Map<Character, Long> registers){
        System.out.print("a: " + registers.getOrDefault('a', 0L));
        System.out.print(", ");
        System.out.print("b: " + registers.getOrDefault('b', 0L));
        System.out.print(", ");
        System.out.print("c: " + registers.getOrDefault('c', 0L));
        System.out.print(", ");
        System.out.print("d: " + registers.getOrDefault('d', 0L));
        System.out.print(", ");
        System.out.print("e: " + registers.getOrDefault('e', 0L));
        System.out.print(", ");
        System.out.print("f: " + registers.getOrDefault('f', 0L));
        System.out.print(", ");
        System.out.print("g: " + registers.getOrDefault('g', 0L));
        System.out.print(", ");
        System.out.print("h: " + registers.getOrDefault('h', 0L));
        System.out.print("\n");
    }

}
