package com.ben.aoc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day10 day10 = new Day10();

    @Test
    public void TestPuzzle1(){
        assertEquals("should be 1,0,...",0, day10.puzzle1("2"));
        assertEquals("should be 2,1,0,...",2, day10.puzzle1("3"));
    }

    @Test
    public void TestPuzzle2SampleInputs(){
        assertEquals("a2582a3a0e66e6e86e3812dcb672a272", day10.puzzle2(""));
        assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", day10.puzzle2("1,2,3"));
    }

}
