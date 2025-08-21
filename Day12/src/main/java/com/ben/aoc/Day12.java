package com.ben.aoc;


import java.util.*;

public class Day12 {

    public long puzzle1(List<String> input) {
        Set<Integer> group0 = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        while (!queue.isEmpty()){
            int id = queue.remove();
            group0.add(id);
            queue.addAll(getConnections(input.get(id)));
            queue.removeAll(group0);
        }

        return group0.size();
    }

    public long puzzle2(List<String> input) {
        return 0;
    }

    private List<Integer> getConnections(String line){
        return Arrays.stream(line.split(" <-> ")[1].split(", ")).map(Integer::parseInt).toList();
    }

}
