package com.ben.aoc;


import java.util.ArrayList;
import java.util.List;

public class Day14 {
    Day10 hasher = new Day10();

    public long puzzle1(String input) {
        long used = 0;
        List<String> hashes = new ArrayList<>();
        for(int i = 0; i < 128; i++){
            hashes.add(binaryHash(hasher.puzzle2(input + "-" + i)));
        }

        for(String hash : hashes){
            used += hash.chars().filter(c -> c == '1').count();
        }

        return used;
    }

    public long puzzle2(String input) {
        return 0;
    }

    private String binaryHash(String hex){
        hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("a", "1010");
        hex = hex.replaceAll("b", "1011");
        hex = hex.replaceAll("c", "1100");
        hex = hex.replaceAll("d", "1101");
        hex = hex.replaceAll("e", "1110");
        hex = hex.replaceAll("f", "1111");
        return hex;
    }

}
