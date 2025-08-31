package com.ben.aoc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day21 day21 = new Day21();

    List<String> testInput = List.of(
            "../.# => ##./#../...",
            ".#./..#/### => #..#/..../..../#..#");

    @Test
    public void TestPicture(){
        Picture p = new Picture("#..#/..../..../#..#");
        Picture tl = new Picture("#./..");
        Picture tr = new Picture(".#/..");
        Picture bl = new Picture("../#.");
        Picture br = new Picture("../.#");
        Picture joined = new Picture("#..#/..../..../#..#");
        List<Picture> split = List.of(tl, tr, bl, br);
        assertEquals(split, p.split());
        assertEquals(joined, new Picture(split));
    }

    @Test
    public void TestPuzzle1(){
        assertEquals(12, day21.puzzle1(testInput, 2));
    }


}
