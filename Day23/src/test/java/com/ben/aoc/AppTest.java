package com.ben.aoc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day23 day23 = new Day23();

    List<String> testInput = List.of("set a 1",
            "set a 2",
            "mul a a");


    @Test
    public void TestPuzzle1(){
        assertEquals(1, day23.puzzle1(testInput));
    }



}
