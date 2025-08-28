package com.ben.aoc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day18 day18 = new Day18();

    List<String> testInput = List.of("set a 1",
            "add a 2",
            "mul a a",
            "mod a 5",
            "snd a",
            "set a 0",
            "rcv a",
            "jgz a -1",
            "set a 1",
            "jgz a -2");

    List<String> testInput2 = List.of("snd 1",
            "snd 2",
            "snd p",
            "rcv a",
            "rcv b",
            "rcv c",
            "rcv d");
    @Test
    public void TestPuzzle1(){
        assertEquals(4, day18.puzzle1(testInput));
    }

    @Test
    public void TestPuzzle2(){
        assertEquals(3, day18.puzzle2(testInput2));
    }


}
