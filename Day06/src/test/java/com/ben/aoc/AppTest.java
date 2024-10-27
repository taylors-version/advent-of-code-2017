package com.ben.aoc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {

    Day6 day6 = new Day6();

    @Test
    public void TestSampleInput(){
        String input = "0 2 7 0";
        assertEquals(5, day6.puzzle1(input));
    }

}
