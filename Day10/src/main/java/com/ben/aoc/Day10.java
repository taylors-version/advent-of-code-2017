package com.ben.aoc;

import com.ben.aoc.collection.CircularList;

import java.util.ArrayList;
import java.util.Arrays;
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

    public String puzzle2(String input) {
        List<Integer> lengths = getAsciiLengths(input);
        CircularList<Integer> circle = createCircle();
        int start = 0;
        int skip = 0;
        for(int round = 0; round < 64; round ++){
            for(Integer length : lengths) {

                List<Integer> sublist = circle.subList(start, start + length);

                for (int pos = 0; pos < length; pos++) {
                    circle.set(start + pos, sublist.get((length - 1) - pos));
                }
                start += length + skip;
                skip++;
            }
        }
        List<Integer>sparseHash = new ArrayList<>();
        for(int i = 0; i < 16; i++){
            List<Integer> sublist = circle.subList(i*16, (i+1) * 16);
            sparseHash.add(sparse(sublist));
        }

        StringBuilder result = new StringBuilder();
        for(Integer hex : sparseHash){
            result.append(String.format("%02x", hex));
        }
        return result.toString();
    }

    private CircularList<Integer> createCircle(){
        CircularList<Integer> circle = new CircularList<>();

        for (int i = 0; i<256; i++){
            circle.add(i);
        }

        return circle;
    }

    private List<Integer> getAsciiLengths(String input){
        List<Integer> lengths = new ArrayList<>();
        for(char c : input.toCharArray()){
            lengths.add((int) c);
        }
        lengths.addAll(Arrays.asList(17, 31, 73, 47, 23));
        return lengths;
    }

    public int sparse(List<Integer> input){
        int result = input.get(0);
        for (int i = 1; i< input.size(); i++){
            result = result ^ input.get(i);
        }
        return result;
    }

}
