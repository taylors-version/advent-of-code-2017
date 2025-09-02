package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day24 day24 = new Day24();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day24.puzzle1(lines));
        System.out.println("puzzle 2: " + day24.puzzle2(lines));
    }
}
