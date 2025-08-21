package com.ben.aoc;


import java.util.*;
import java.util.stream.IntStream;

public class Day12 {

    public long puzzle1(List<String> input) {


        return getGroup(input, 0).size();
    }

    public long puzzle2(List<String> input) {
        int groups = 0;
        Queue<Integer> queue = new ArrayDeque<>(IntStream.range(0, input.size()).boxed().toList());
        while(!queue.isEmpty()){
            int id = queue.remove();
            groups ++;
            queue.removeAll(getGroup(input, id));
        }
        return groups;
    }

    private List<Integer> getConnections(String line){
        return Arrays.stream(line.split(" <-> ")[1].split(", ")).map(Integer::parseInt).toList();
    }

    private Set<Integer> getGroup(List<String> input, int id){
        Set<Integer> group = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(id);

        while (!queue.isEmpty()){
            int nextId = queue.remove();
            group.add(nextId);
            queue.addAll(getConnections(input.get(nextId)));
            queue.removeAll(group);
        }
        return group;
    }

}
