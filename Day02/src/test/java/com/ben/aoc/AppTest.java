package com.ben.aoc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {

    Day2 day2 = new Day2();

    @Test
    public void TestSample1Input(){
        List<String> input = List.of("5 1 9 5\n7 5 3\n2 4 6 8".split("\\n"));
        assertEquals(18, day2.puzzle1(input));
    }

    @Test
    public void TestSample2Input(){
        List<String> input = List.of("5 9 2 8\n9 4 7 3\n3 8 6 5".split("\\n"));
        assertEquals(9, day2.puzzle2(input));
    }

}
