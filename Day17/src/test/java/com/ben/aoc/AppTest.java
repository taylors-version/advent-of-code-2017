package com.ben.aoc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day17 day17 = new Day17();


    @Test
    public void TestPuzzle1(){
        assertEquals(638, day17.puzzle1("3"));
    }


}
