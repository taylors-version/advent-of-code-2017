package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day17 day17 = new Day17();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day17.puzzle1(lines.get(0)));
        System.out.println("puzzle 2: " + day17.puzzle2(lines.get(0)));
    }
}
