package com.ben.aoc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day22 day22 = new Day22();

    List<String> testInput = List.of(
            "..#",
            "#..",
            "...");

    @Test
    public void TestPuzzle1(){
        assertEquals(5587, day22.puzzle1(testInput));
    }

    @Test
    public void TestPuzzle2(){
        assertEquals(2511944, day22.puzzle2(testInput));
    }


}
