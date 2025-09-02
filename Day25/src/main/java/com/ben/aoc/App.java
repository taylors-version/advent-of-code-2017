package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day25 day25 = new Day25();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day25.puzzle1(lines));
        System.out.println("puzzle 2: " + day25.puzzle2(lines));
    }
}
