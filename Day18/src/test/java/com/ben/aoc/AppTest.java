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
    @Test
    public void TestPuzzle1(){
        assertEquals(4, day18.puzzle1(testInput));
    }


}
