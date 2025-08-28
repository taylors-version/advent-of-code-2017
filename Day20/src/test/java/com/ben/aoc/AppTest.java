package com.ben.aoc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day20 day20 = new Day20();

    List<String> testInput = List.of(
            "p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>",
            "p=<4,0,0>, v=<0,0,0>, a=<-2,0,0>");


    @Test
    public void TestPuzzle1(){
        assertEquals(0, day20.puzzle1(testInput));
    }


}
