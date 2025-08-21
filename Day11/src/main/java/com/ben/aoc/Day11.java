package com.ben.aoc;


import org.javatuples.Pair;

import java.util.*;

public class Day11 {

    public long puzzle1(String input) {
        return (getDistance(Arrays.asList(input.split(","))));
    }

    public long puzzle2(String input) {
        long max = 0;
        List<String> directions = Arrays.asList(input.split(","));
        for(int i = 1; i <= directions.size(); i++){
            long length = getDistance(directions.subList(0, i));
            max = Math.max(max, length);
        }


        return max;
    }

    private long getDistance(List<String> directions){
        Pair<Integer, Integer> location = getLocation(directions);
        int x = location.getValue0();
        int y = location.getValue1();
        if(y <= x){
            return x;
        }
        return x + (y-x)/2;
    }

    private Pair<Integer, Integer> getLocation(List<String> directions){
        int y = 0;
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
        y=2*n+(ne+nw);

        return new Pair<>(Math.abs(x),Math.abs(y));
    }

}
