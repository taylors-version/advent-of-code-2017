package com.ben.aoc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {

    Day4 day4 = new Day4();

    @Test
    public void TestSample1Input(){
        List<String> input = new ArrayList<>();
        input.add("aa bb cc dd ee");
        assertEquals(1, day4.puzzle1(input));
    }

    @Test
    public void TestSample2Input(){
        List<String> input = new ArrayList<>();
        input.add("aa bb cc dd aa");
        assertEquals(0, day4.puzzle1(input));
    }

    @Test
    public void TestSample3Input(){
        List<String> input = new ArrayList<>();
        input.add("aa bb cc dd aaa");
        assertEquals(1, day4.puzzle1(input));
    }

    @Test
    public void TestAnagramSample1Input(){
        List<String> input = new ArrayList<>();
        input.add("abcde fghij");
        assertEquals(1, day4.puzzle2(input));
    }

    @Test
    public void TestAnagramSample2Input(){
        List<String> input = new ArrayList<>();
        input.add("abcde xyz ecdab");
        assertEquals(0, day4.puzzle2(input));
    }

}
