package com.ben.aoc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Day7 {
    ArrayList<String> nodes = new ArrayList<>();

    public String puzzle1(List<String> input) {
        nodes = new ArrayList<String>(input);
        nodes.sort(Comparator.comparingInt(String::length));

        String[] leafs = nodes.get(input.size() - 1).split(", ");
        String parent = leafs[leafs.length - 1];
        String leaf = parent;

        while(parent != null){
            leaf = parent;
            parent = getParent(leaf);
        }

        return leaf;
    }

    public long puzzle2(List<String> input) {
        int result = 0;

        return result;
    }

    private String getParent(String leaf){
        for(String node: nodes){
            String[] children = node.split("->");
            if(children.length > 1 && children[1].contains(leaf)){
                return node.split(" ")[0];
            }
        }

        return null;
    }


}
