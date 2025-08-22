package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day16 day16 = new Day16();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day16.puzzle1(lines.get(0)));
        System.out.println("puzzle 2: " + day16.puzzle2(lines.get(0)));
    }
}
