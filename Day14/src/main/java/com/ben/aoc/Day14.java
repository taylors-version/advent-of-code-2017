package com.ben.aoc;


import java.util.*;

public class Day14 {
    Day10 hasher = new Day10();

    public long puzzle1(String input) {
        long used = 0;
        for(int i = 0; i < 128; i++){
            used += binaryHash(hasher.puzzle2(input + "-" + i)).chars().filter(c -> c == '1').count();
        }

        return used;
    }

    public long puzzle2(String input) {
        long groups = 0;
        Set<IntPoint> used = findUsed(input);
        Queue<IntPoint> queue = new ArrayDeque<>(used);
        while(!queue.isEmpty()){
            IntPoint point = queue.remove();
            groups++;
            Queue<IntPoint> group = new ArrayDeque<>();
            group.add(point);
            Set<IntPoint> visited = new HashSet<>();
            IntPoint current;
            while (!group.isEmpty()){
                current = group.remove();
                visited.add(current);
                List<IntPoint> neighbours = current.allNeighbours().stream().map(p -> (IntPoint)p).filter(used::contains).toList();
                group.addAll(neighbours);
                group.removeAll(visited);
            }
            queue.removeAll(visited);
        }


        return groups;
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

    private Set<IntPoint> findUsed(String input){
        Set<IntPoint> used = new HashSet<>();
        for(int i = 0; i < 128; i++){
            String hash = binaryHash(hasher.puzzle2(input + "-" + i));
            for(int j = 0; j < hash.length(); j++){
                if(hash.charAt(j) == '1'){
                    used.add(new IntPoint(j, i));
                }
            }
        }

        return used;
    }

}
