package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day21 day21 = new Day21();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day21.puzzle1(lines, 5));
        System.out.println("puzzle 2: " + day21.puzzle2(lines));
    }
}
