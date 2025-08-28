package com.ben.aoc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day19 day19 = new Day19();

    List<String> testInput = List.of(
            "     |          ",
            "     |  +--+    ",
            "     A  |  C    ",
            " F---|----E|--+ ",
            "     |  |  |  D ",
            "     +B-+  +--+ ");


    @Test
    public void TestPuzzle1(){
        assertEquals("ABCDEF", day19.puzzle1(testInput));
    }

    @Test
    public void TestPuzzle2(){
        assertEquals(38, day19.puzzle2(testInput));
    }

}
