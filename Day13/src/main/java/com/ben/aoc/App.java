package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day13 day13 = new Day13();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day13.puzzle1(lines));
        System.out.println("puzzle 2: " + day13.puzzle2(lines));
    }
}
