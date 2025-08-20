package com.ben.aoc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day10 day10 = new Day10();

    @Test
    public void TestPuzzle1(){
        assertEquals("should be 1,0,...",0, day10.puzzle1("2"));
        assertEquals("should be 2,1,0,...",2, day10.puzzle1("3"));
    }

}
