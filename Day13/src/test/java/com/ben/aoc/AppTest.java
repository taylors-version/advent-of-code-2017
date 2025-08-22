package com.ben.aoc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day13 day13 = new Day13();

    List<String> testInput = Arrays.asList(
            "0: 3",
            "1: 2",
            "4: 4",
            "6: 4");

    @Test
    public void TestPuzzle1(){
        assertEquals(24, day13.puzzle1(testInput));
    }

    @Test
    public void TestPuzzle2(){
        assertEquals(10, day13.puzzle2(testInput));
    }
}
