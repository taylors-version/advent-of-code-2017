package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day22 day22 = new Day22();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day22.puzzle1(lines));
        System.out.println("puzzle 2: " + day22.puzzle2(lines));
    }
}
