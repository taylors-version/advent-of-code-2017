package com.ben.aoc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day12 day12 = new Day12();

    List<String> testInput = Arrays.asList("0 <-> 2",
            "1 <-> 1",
            "2 <-> 0, 3, 4",
            "3 <-> 2, 4",
            "4 <-> 2, 3, 6",
            "5 <-> 6",
            "6 <-> 4, 5");

    @Test
    public void TestPuzzle1(){
        assertEquals(6, day12.puzzle1(testInput));
    }

    @Test
    public void TestPuzzle2(){
        assertEquals(2, day12.puzzle2(testInput));
    }

}
