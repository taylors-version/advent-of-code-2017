package com.ben.aoc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day24 day24 = new Day24();

    List<String> testInput = List.of(
            "0/2",
            "2/2",
            "2/3",
            "3/4",
            "3/5",
            "0/1",
            "10/1",
            "9/10");

    @Test
    public void TestPuzzle1(){
        assertEquals(31, day24.puzzle1(testInput));
    }

    @Test
    public void TestPuzzle2(){
        assertEquals(19, day24.puzzle2(testInput));
    }


}
