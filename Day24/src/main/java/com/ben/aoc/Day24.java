package com.ben.aoc;


import org.javatuples.Pair;

import java.util.*;

public class Day24 {
    Set<Pair<Integer, Integer>> ports = new HashSet<>();

    public long puzzle1(List<String> input) {
        for(String line : input){
            String[] ends = line.split("/");
            ports.add(new Pair<>(Integer.parseInt(ends[0]), Integer.parseInt(ends[1])));
        }

        return maxBridgeSize();
    }

    public long puzzle2(List<String> input) {
        for(String line : input){
            String[] ends = line.split("/");
            ports.add(new Pair<>(Integer.parseInt(ends[0]), Integer.parseInt(ends[1])));
        }

        return maxLongestBridgeSize();
    }

    private int maxBridgeSize(){
        int max = 0;

        Queue<Pair<Set<Pair<Integer, Integer>>, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(new HashSet<>(), 0));
        Set<Pair<Set<Pair<Integer, Integer>>, Integer>> visited = new HashSet<>();
        Pair<Set<Pair<Integer, Integer>>, Integer> current;

        while (!queue.isEmpty()){
            current = queue.remove();
            Set<Pair<Set<Pair<Integer, Integer>>, Integer>> next = getNext(current);
            if(next.isEmpty()){
                int currentSize = current.getValue0().stream()
                        .mapToInt(p -> p.getValue0() + p.getValue1())
                        .sum();
                max = Math.max(max, currentSize);
            }else {
                visited.add(current);
                queue.addAll(next);
                queue.removeAll(visited);
            }

        }

        return max;
    }

    private int maxLongestBridgeSize(){
        Map<Integer, Integer> maximum = new HashMap<>();

        Queue<Pair<Set<Pair<Integer, Integer>>, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(new HashSet<>(), 0));
        Set<Pair<Set<Pair<Integer, Integer>>, Integer>> visited = new HashSet<>();
        Pair<Set<Pair<Integer, Integer>>, Integer> current;

        while (!queue.isEmpty()){
            current = queue.remove();
            Set<Pair<Set<Pair<Integer, Integer>>, Integer>> next = getNext(current);
            if(next.isEmpty()){
                    int length = current.getValue0().size();
                    int currentSize = current.getValue0().stream()
                            .mapToInt(p -> p.getValue0() + p.getValue1())
                            .sum();
                    maximum.merge(length, currentSize, Math::max);

            }else {
                visited.add(current);
                queue.addAll(next);
                queue.removeAll(visited);
            }

        }
        int length =0;
        int max = 0;
        for(Map.Entry<Integer, Integer> e: maximum.entrySet()){
            if(e.getKey() > length){
                max = e.getValue();
            }
        }

        return max;
    }

    private Set<Pair<Set<Pair<Integer, Integer>>, Integer>> getNext(Pair<Set<Pair<Integer, Integer>>, Integer> current){
        Set<Pair<Integer, Integer>> used = current.getValue0();
        int pins = current.getValue1();
        Set<Pair<Integer, Integer>> available = new HashSet<>(ports);
        available.removeAll(used);
        Set<Pair<Set<Pair<Integer, Integer>>, Integer>> next = new HashSet<>();
        for(Pair<Integer, Integer> port : available){
            int a = port.getValue0();
            int b = port.getValue1();
            if(a == pins || b == pins){
                int newRequired = a == pins ? b : a;
                Set<Pair<Integer, Integer>> bridge = new HashSet<>(used);
                bridge.add(port);
                next.add(new Pair<>(bridge, newRequired));
            }
        }
        return next;
    }

}
