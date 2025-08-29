package com.ben.aoc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day20 day20 = new Day20();

    List<String> testInput = List.of(
            "p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>",
            "p=<4,0,0>, v=<0,0,0>, a=<-2,0,0>");
    List<String> testInput2 = List.of(
            "p=<-6,0,0>, v=<3,0,0>, a=<0,0,0>",
            "p=<-4,0,0>, v=<2,0,0>, a=<0,0,0>",
            "p=<-2,0,0>, v=<1,0,0>, a=<0,0,0>",
            "p=<3,0,0>, v=<-1,0,0>, a=<0,0,0>");


    @Test
    public void TestPuzzle1(){
        assertEquals(0, day20.puzzle1(testInput));
    }

    @Test
    public void TestTick(){
        Particle p = new Particle("p=<-113,477,1471>, v=<42,-79,-10>, a=<-4,6,-11>");
        assertEquals(-113, p.xPos);
    }

    @Test
    public void TestPuzzle2(){
        assertEquals(1, day20.puzzle2(testInput2));
    }


}
