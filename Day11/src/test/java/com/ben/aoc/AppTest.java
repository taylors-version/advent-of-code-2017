package com.ben.aoc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day11 day11 = new Day11();

    @Test
    public void TestPuzzle1(){
        assertEquals(3, day11.puzzle1("ne,ne,ne"));
        assertEquals(0, day11.puzzle1("ne,ne,sw,sw"));
        assertEquals(2, day11.puzzle1("ne,ne,s,s"));
        assertEquals(3, day11.puzzle1("se,sw,se,sw,sw"));
    }

}
