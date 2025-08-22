package com.ben.aoc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day14 day14 = new Day14();

    @Test
    public void TestPuzzle1(){
        assertEquals(8108, day14.puzzle1("flqrgnkx"));
    }


}
