package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day20 day20 = new Day20();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day20.puzzle1(lines));
        System.out.println("puzzle 2: " + day20.puzzle2(lines));
    }
}
