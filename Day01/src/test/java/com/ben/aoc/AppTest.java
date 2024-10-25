package com.ben.aoc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

    Day1 day1 = new Day1();

    @Test
    public void Test1122(){
        assertEquals(3, day1.puzzle1("1122"));
    }

    @Test
    public void Test1111(){
        assertEquals(4, day1.puzzle1("1111"));
    }

    @Test
    public void Test1234(){
        assertEquals(0, day1.puzzle1("1234"));
    }

    @Test
    public void Test91212129(){
        assertEquals(9, day1.puzzle1("91212129"));
    }

    @Test
    public void Test1212Part2(){
        assertEquals(6, day1.puzzle2("1212"));
    }
}
