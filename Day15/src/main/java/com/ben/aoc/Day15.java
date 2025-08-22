package com.ben.aoc;


import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Day15 {
    private final long modulo = 2147483647;
    private final long factorA = 16807;
    private final long factorB = 48271;

    public long puzzle1(List<String> input) {
        long matches = 0;
        long genA = Long.parseLong(input.get(0).split(" ")[4]);
        long genB = Long.parseLong(input.get(1).split(" ")[4]);

        for(int i = 0; i < 40000000; i++){
            genA = nextNumber(genA, factorA);
            genB = nextNumber(genB, factorB);
            String binaryA = StringUtils.leftPad(Long.toBinaryString(genA), 32, '0');
            String binaryB = StringUtils.leftPad(Long.toBinaryString(genB), 32, '0');
            if(binaryA.substring(binaryA.length()-16).equals(binaryB.substring(binaryB.length()-16))){
                matches++;
            }
        }

        return matches;
    }

    public long puzzle2(List<String> input) {
        long matches = 0;
        long genA = Long.parseLong(input.get(0).split(" ")[4]);
        long genB = Long.parseLong(input.get(1).split(" ")[4]);


        for(int i=0; i < 5000000; i++){
            genA = nextNumber(genA, factorA);
            genB = nextNumber(genB, factorB);
            while(genA % 4 != 0) {
                genA = nextNumber(genA, factorA);
            }
            while(genB % 8 != 0) {
                genB = nextNumber(genB, factorB);
            }
            String binaryA = StringUtils.leftPad(Long.toBinaryString(genA), 32, '0');
            String binaryB = StringUtils.leftPad(Long.toBinaryString(genB), 32, '0');
            if(binaryA.substring(binaryA.length()-16).equals(binaryB.substring(binaryB.length()-16))){
                matches++;
            }
        }

        return matches;
    }

    private long nextNumber(long seed, long factor){
        return (seed*factor) % modulo;
    }

}
