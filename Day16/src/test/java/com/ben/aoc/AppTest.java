package com.ben.aoc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day16 day16 = new Day16();


    @Test
    public void TestPuzzle1(){
        assertEquals("opabcdefghijklmn", day16.puzzle1("s2"));
        assertEquals("abedcfghijklmnop", day16.puzzle1("x2/4"));
        assertEquals("afcdebghijklmnop", day16.puzzle1("pb/f"));
    }


}
