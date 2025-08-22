package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day15 day15 = new Day15();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day15.puzzle1(lines));
        System.out.println("puzzle 2: " + day15.puzzle2(lines));
    }
}
