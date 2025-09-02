package com.ben.aoc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day25 day25 = new Day25();

    String input = "Begin in state A.\n" +
            "Perform a diagnostic checksum after 6 steps.\n" +
            "\n" +
            "In state A:\n" +
            "  If the current value is 0:\n" +
            "    - Write the value 1.\n" +
            "    - Move one slot to the right.\n" +
            "    - Continue with state B.\n" +
            "  If the current value is 1:\n" +
            "    - Write the value 0.\n" +
            "    - Move one slot to the left.\n" +
            "    - Continue with state B.\n" +
            "\n" +
            "In state B:\n" +
            "  If the current value is 0:\n" +
            "    - Write the value 1.\n" +
            "    - Move one slot to the left.\n" +
            "    - Continue with state A.\n" +
            "  If the current value is 1:\n" +
            "    - Write the value 1.\n" +
            "    - Move one slot to the right.\n" +
            "    - Continue with state A.";
    List<String> testInput = Arrays.asList(input.split("\n"));

    @Test
    public void TestPuzzle1(){
        assertEquals(3, day25.puzzle1(testInput));
    }

}
