package com.ben.aoc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day8 day8 = new Day8();

    String sampleInput = "b inc 5 if a > 1\n" +
            "a inc 1 if b < 5\n" +
            "c dec -10 if a >= 1\n" +
            "c inc -20 if c == 10";

    @Test
    public void TestSampleInput(){
        List<String> input = List.of(sampleInput.split("\\n"));
        assertEquals(1, day8.puzzle1(input));
    }


}
