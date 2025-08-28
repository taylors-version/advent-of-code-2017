package com.ben.aoc;


import java.util.*;

public class Day18 {

    public long puzzle1(List<String> input) {
        Map<Character, Long> registers = new HashMap<>();
        long lastFrequency = 0;
        boolean recovered = false;
        int i = 0;
        while(!recovered){
            String[] line = input.get(i).split(" ");
            i++;
            switch (line[0]){
                case "snd":
                    lastFrequency = getValue(registers, line[1]);
                    break;
                case "set":
                    registers.put(line[1].charAt(0), getValue(registers, line[2]));
                    break;
                case "add":
                    add(registers, line);
                    break;
                case "mul":
                    mul(registers, line);
                    break;
                case "mod":
                    mod(registers, line);
                    break;
                case "rcv":
                    recovered = getValue(registers, line[1]) != 0;
                    break;
                case "jgz":
                    if(getValue(registers, line[1]) > 0){
                        i+= (int) (getValue(registers, line[2]) - 1);
                    }
            }
        }

        return lastFrequency;
    }

    public long puzzle2(List<String> input) {
        long sendCount = 0;
        boolean aWaiting = false;
        boolean bWaiting = false;
        Map<Character, Long> aRegisters = new HashMap<>();
        Map<Character, Long> bRegisters = new HashMap<>();
        aRegisters.put('p' ,0L);
        bRegisters.put('p' ,1L);
        Queue<Long> aQueue = new ArrayDeque<>();
        Queue<Long> bQueue = new ArrayDeque<>();

        int aPos = 0;
        int bPos = 0;

        while(!aWaiting || !bWaiting){
            if(!aWaiting){
                String[] line = input.get(aPos).split(" ");
                aPos++;
                switch (line[0]){
                    case "snd":
                        bQueue.add(getValue(aRegisters, line[1]));
                        bWaiting = false;
                        break;
                    case "set":
                        aRegisters.put(line[1].charAt(0), getValue(aRegisters, line[2]));
                        break;
                    case "add":
                        add(aRegisters, line);
                        break;
                    case "mul":
                        mul(aRegisters, line);
                        break;
                    case "mod":
                        mod(aRegisters, line);
                        break;
                    case "rcv":
                        if(aQueue.isEmpty()){
                            aWaiting = true;
                            aPos--;
                        }else {
                            aRegisters.put(line[1].charAt(0), aQueue.remove());
                        }
                        break;
                    case "jgz":
                        if(getValue(aRegisters, line[1]) > 0){
                            aPos+= (int) (getValue(aRegisters, line[2]) - 1);
                        }
                        break;
                }
            }
            if(!bWaiting){
                String[] line = input.get(bPos).split(" ");
                bPos++;
                switch (line[0]){
                    case "snd":
                        aQueue.add(getValue(bRegisters, line[1]));
                        aWaiting = false;
                        sendCount++;
                        break;
                    case "set":
                        bRegisters.put(line[1].charAt(0), getValue(bRegisters, line[2]));
                        break;
                    case "add":
                        add(bRegisters, line);
                        break;
                    case "mul":
                        mul(bRegisters, line);
                        break;
                    case "mod":
                        mod(bRegisters, line);
                        break;
                    case "rcv":
                        if(bQueue.isEmpty()){
                            bWaiting = true;
                            bPos--;
                        }else {
                            bRegisters.put(line[1].charAt(0), bQueue.remove());
                        }
                        break;
                    case "jgz":
                        if(getValue(bRegisters, line[1]) > 0){
                            bPos+= (int) (getValue(bRegisters, line[2]) - 1);
                        }
                        break;
                }
            }
        }

        return sendCount;
    }

    private long getValue(Map<Character, Long> registers, String val){
        if(val.charAt(0) < 58){
            return Long.parseLong(val);
        }else {
            return registers.getOrDefault(val.charAt(0), 0L);
        }
    }

    private void add(Map<Character, Long> registers, String[] addOp){
        char location = addOp[1].charAt(0);
        long value = getValue(registers, addOp[2]);
        registers.merge(location, value, Long::sum);
    }

    private void mul(Map<Character, Long> registers, String[] mulOp){
        char location = mulOp[1].charAt(0);
        long value = getValue(registers, mulOp[2]);
        registers.computeIfPresent(location, (a, b) -> b * value);
    }

    private void mod(Map<Character, Long> registers, String[] modOp){
        char location = modOp[1].charAt(0);
        long value = getValue(registers, modOp[2]);
        registers.computeIfPresent(location, (a, b) -> b % value);
    }

}
