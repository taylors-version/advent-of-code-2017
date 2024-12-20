package com.ben.aoc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {

    Day5 day5 = new Day5();

    @Test
    public void TestSampleInput(){
        List<String> input = List.of("0\n3\n0\n1\n-3".split("\n"));
        assertEquals(5, day5.puzzle1(input));
    }

    @Test
    public void TestSampleInput2(){
        List<String> input = List.of("0\n3\n0\n1\n-3".split("\n"));
        assertEquals(10, day5.puzzle2(input));
    }

}
