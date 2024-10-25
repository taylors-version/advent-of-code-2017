package com.ben.aoc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void Test1122(){
        Day1 day1 = new Day1("1122.txt");
        assertEquals(3, day1.puzzle1());
    }

    @Test
    public void Test1111(){
        Day1 day1 = new Day1("1111.txt");
        assertEquals(4, day1.puzzle1());
    }

    @Test
    public void Test1234(){
        Day1 day1 = new Day1("1234.txt");
        assertEquals(0, day1.puzzle1());
    }

    @Test
    public void Test91212129(){
        Day1 day1 = new Day1("91212129.txt");
        assertEquals(9, day1.puzzle1());
    }
}
