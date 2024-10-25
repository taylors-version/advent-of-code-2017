package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day1 day1 = new Day1();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day1.puzzle1(lines.get(0)));
        System.out.println("puzzle 2: " + day1.puzzle2(lines.get(0)));
    }
}
