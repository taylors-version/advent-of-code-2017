package com.ben.aoc;


public class Day16 {

    public String puzzle1(String input) {
        String result = "abcdefghijklmnop";
        for(String step : input.split(",")){
            result = switch (step.charAt(0)) {
                case 's' -> spin(result, step);
                case 'x' -> exchange(result, step);
                case 'p' -> partner(result, step);
                default -> result;
            };
        }

        return result;
    }

    public String puzzle2(String input) {
        return "";
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
