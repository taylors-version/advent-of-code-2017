package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day19 day19 = new Day19();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day19.puzzle1(lines));
        System.out.println("puzzle 2: " + day19.puzzle2(lines));
    }
}
