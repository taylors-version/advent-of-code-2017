package com.ben.aoc;


import org.javatuples.Pair;

import java.util.*;
import java.util.stream.Stream;

public class Day11 {

    public long puzzle1(String input) {
        List<String> directions = Arrays.asList(input.split(","));

        return bfs(getLocation(directions));

    }

    public long puzzle2(String input) {
        return 0;
    }

    private Pair<Integer, Double> getLocation(List<String> directions){
        double y = 0;
        int x = 0;
        int n = Collections.frequency(directions, "n");
        int ne = Collections.frequency(directions, "ne");
        int se = Collections.frequency(directions, "se");
        int s = Collections.frequency(directions, "s");
        int sw = Collections.frequency(directions, "sw");
        int nw = Collections.frequency(directions, "nw");

        n = n-s;
        ne = ne-sw;
        nw = nw-se;

        x = ne-nw;
        y=n+0.5*(ne+nw);

        return new Pair<>(Math.abs(x),Math.abs(y));
    }

    private List<String> directionsFromMap(Map<String, Integer> map){
        List<String> directions = new ArrayList<>();
        for(int i = 0; i < map.getOrDefault("n", 0); i++){
            directions.add("n");
        }
        for(int i = 0; i < map.getOrDefault("ne", 0); i++){
            directions.add("ne");
        }

        return directions;
    }

    private int bfs(Pair<Integer, Double> location){
        int steps = 0;

        HashMap<String, Integer> moves = new HashMap<>();
        moves.put("n", 0);
        moves.put("ne", 0);

        Queue<HashMap<String, Integer>> queue = new ArrayDeque<>();
        queue.add(moves);
        Set<HashMap<String, Integer>> visited = new HashSet<>();

        HashMap<String, Integer> currentNode;

        while(!queue.isEmpty()){
            currentNode = queue.remove();
            int n = currentNode.getOrDefault("n", 0);
            int ne = currentNode.getOrDefault("ne", 0);
            if(getLocation(directionsFromMap(currentNode)).equals(location)){
                return n+ne;
            }else{
                visited.add(currentNode);

                HashMap<String, Integer> nMap = new HashMap<>();
                HashMap<String, Integer> neMap = new HashMap<>();
                nMap.put("n", n+1);
                nMap.put("ne", ne);
                neMap.put("n", n);
                neMap.put("ne", ne+1);
                queue.add(nMap);
                queue.add(neMap);
            }
        }

        return steps;
    }


}
