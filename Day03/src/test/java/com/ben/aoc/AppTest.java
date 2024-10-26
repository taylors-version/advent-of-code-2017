package com.ben.aoc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {

    Day3 day3 = new Day3();

    @Test
    public void TestSample1Input(){
        assertEquals(0, day3.puzzle1(1));
    }

    @Test
    public void TestSampleInput2(){
        assertEquals(3, day3.puzzle1(12));
    }

    @Test
    public void TestSampleInput3(){
        assertEquals(2, day3.puzzle1(23));
    }
}
