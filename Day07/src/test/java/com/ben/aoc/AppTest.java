package com.ben.aoc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {
    Day7 day7 = new Day7();

    String sampleInput = "pbga (66)\n" +
            "xhth (57)\n" +
            "ebii (61)\n" +
            "havc (66)\n" +
            "ktlj (57)\n" +
            "fwft (72) -> ktlj, cntj, xhth\n" +
            "qoyq (66)\n" +
            "padx (45) -> pbga, havc, qoyq\n" +
            "tknk (41) -> ugml, padx, fwft\n" +
            "jptl (61)\n" +
            "ugml (68) -> gyxo, ebii, jptl\n" +
            "gyxo (61)\n" +
            "cntj (57)";

    @Test
    public void TestSampleInput(){
        List<String> input = List.of(sampleInput.split("\\n"));
        assertEquals("tknk", day7.puzzle1(input));
    }

    @Test
    public void TestSampleInput2(){
        List<String> input = List.of(sampleInput.split("\\n"));
        assertEquals(60, day7.puzzle2(input));
    }

}
