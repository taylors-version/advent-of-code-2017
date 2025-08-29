package com.ben.aoc;


import java.util.*;

public class Day21 {

    public long puzzle1(List<String> input, int iterations) {
        Picture artwork = new Picture(".#./..#/###");
        List<Picture> enhancements = new ArrayList<>();
        for(String line : input){
            String[] split = line.split(" => ");
            enhancements.add(new Picture(split[0], new Picture(split[1])));
        }
        System.out.println(artwork);
        for(int i = 0; i < iterations; i++){
            List<Picture> split = artwork.split();
            List<Picture> translated = new ArrayList<>();
            for(Picture p : split){
                for(Picture e : enhancements){
                    if(e.matches(p)){
                        translated.add(e.output);
                        break;
                    }
                }
            }
            artwork = new Picture(translated);
            System.out.println(artwork);
        }

        return artwork.numberOfOn();
    }

    public long puzzle2(List<String> input) {
        return 0;
    }

}
