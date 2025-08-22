package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day14 day14 = new Day14();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day14.puzzle1(lines.get(0)));
        System.out.println("puzzle 2: " + day14.puzzle2(lines.get(0)));
    }
}
