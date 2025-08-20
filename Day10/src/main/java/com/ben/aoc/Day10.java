package com.ben.aoc;

import com.ben.aoc.collection.CircularList;

import java.util.List;

public class Day10 {

    public long puzzle1(String input) {
        CircularList<Integer> circle = createCircle();
        int start = 0;
        int skip = 0;

        String[] moves = input.split(",");
        for(String move : moves) {

            int length = Integer.parseInt(move);
            List<Integer> sublist = circle.subList(start, start + length);

            for (int pos = 0; pos < length; pos++) {
                circle.set(start + pos, sublist.get((length - 1) - pos));
            }
            start += length + skip;
            skip++;
        }
        return circle.get(0) * circle.get(1);
    }

    public long puzzle2(String input) {
        return 0;
    }

    private CircularList<Integer> createCircle(){
        CircularList<Integer> circle = new CircularList<>();

        for (int i = 0; i<256; i++){
            circle.add(i);
        }

        return circle;
    }

}
