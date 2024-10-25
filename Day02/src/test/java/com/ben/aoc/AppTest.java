package com.ben.aoc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {

    Day2 day2 = new Day2();

    @Test
    public void Test1122(){

        List<String> input = List.of("5 1 9 5\n7 5 3\n2 4 6 8".split("\\n"));
        assertEquals(18, day2.puzzle1(input));
    }

}
