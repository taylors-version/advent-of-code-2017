package com.ben.aoc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day9 day9 = new Day9();

    @Test
    public void TestSampleInputs(){
        assertEquals(1, day9.puzzle1("{}"));
        assertEquals(6, day9.puzzle1("{{{}}}"));
        assertEquals(5, day9.puzzle1("{{},{}}"));
        assertEquals(16, day9.puzzle1("{{{},{},{{}}}}"));
        assertEquals(1, day9.puzzle1("{<a>,<a>,<a>,<a>}"));
        assertEquals(9, day9.puzzle1("{{<ab>},{<ab>},{<ab>},{<ab>}}"));
        assertEquals(9, day9.puzzle1("{{<!!>},{<!!>},{<!!>},{<!!>}}"));
        assertEquals(3, day9.puzzle1("{{<a!>},{<a!>},{<a!>},{<ab>}}"));
    }


}
