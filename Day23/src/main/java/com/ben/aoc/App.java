package com.ben.aoc;

import java.util.List;

public class App {

    public static void main( String[] args )
    {
        Day23 day23 = new Day23();
        List<String> lines = Util.readFile(App.class, "input.txt");
        System.out.println("puzzle 1: " + day23.puzzle1(lines));
        System.out.println("puzzle 2: " + day23.puzzle2(lines));
    }
}
