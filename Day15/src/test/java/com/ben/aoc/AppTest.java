package com.ben.aoc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day15 day15 = new Day15();
    List<String> testInput = Arrays.asList("Generator A starts with 65",
            "Generator B starts with 8921");

    @Test
    public void TestPuzzle1(){
        assertEquals(588, day15.puzzle1(testInput));
    }

    @Test
    public void TestPuzzle2(){
        assertEquals(309, day15.puzzle2(testInput));
    }
}
