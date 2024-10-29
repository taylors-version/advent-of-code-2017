package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day8 day8 = new Day8();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day8.puzzle1(lines));
        System.out.println("puzzle 2: " + day8.puzzle2(lines)); //12882 too high
    }
}
