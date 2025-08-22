package com.ben.aoc;


import java.util.HashMap;
import java.util.Map;

public class Day16 {

    public String puzzle1(String input) {

        return dance("abcdefghijklmnop", input);
    }

    public String puzzle2(String input) {
        Map<String, Integer> patternToIndex = new HashMap<>();
        Map<Integer, String> indexToPattern = new HashMap<>();
        String result = "abcdefghijklmnop";
        int index = 0;
        while (!patternToIndex.containsKey(result)) {
            patternToIndex.put(result, index);
            indexToPattern.put(index, result);
            result = dance(result, input);
            index++;
        }


        return indexToPattern.get(1000000000 % index);
    }

    private String dance(String input, String dance){
        for(String step : dance.split(",")){
            input = switch (step.charAt(0)) {
                case 's' -> spin(input, step);
                case 'x' -> exchange(input, step);
                case 'p' -> partner(input, step);
                default -> input;
            };
        }

        return input;
    }

    private String spin(String input, String command){
        int count = Integer.parseInt(command.substring(1));
        String sub = input.substring(input.length() - count);
        return sub + input.substring(0, input.length() - count);
    }

    private String exchange(String input, String command){
        String[] positions = command.substring(1).split("/");
        int a = Integer.parseInt(positions[0]);
        int b = Integer.parseInt(positions[1]);
        char[] c = input.toCharArray();
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;

        return new String(c);
    }

    private String partner(String input, String command){
        char a = command.charAt(1);
        char b = command.charAt(3);

        input = input.replace(a, '!');
        input = input.replace(b, a);
        input = input.replace('!', b);
        return input;
    }
}
