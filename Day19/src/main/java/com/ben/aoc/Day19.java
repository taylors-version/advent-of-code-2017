package com.ben.aoc;


import java.util.*;

public class Day19 {
    char[][] map;

    public String puzzle1(List<String> input) {
        StringBuilder result = new StringBuilder();
        map = new char[input.size()][];
        for(int i = 0; i < input.size(); i++){
            map[i] = input.get(i).toCharArray();
        }

        IntPoint point = new IntPoint(input.get(0).indexOf('|'), 0);
        char value = '|';
        Direction dir = new Direction('d');

        while (true){
            while (value != '+'){
                if(value == ' '){
                    return result.toString();
                }else if(Character.isLetter(value)){
                    result.append(value);
                }
                point = (IntPoint) point.getByDirection(dir);
                value = getValueAtPoint(point);
            }
            if(getValueAtPoint((IntPoint) point.getByDirection(dir.rotateClockwise())) != ' '){
                dir = dir.rotateClockwise();
            }else {
                dir = dir.rotateAntiClockwise();
            }
            point = (IntPoint) point.getByDirection(dir);
            value = getValueAtPoint(point);
        }

    }

    public String puzzle2(List<String> input) {
        return "";
    }

    private char getValueAtPoint(IntPoint point){
        int x = point.getX();
        int y = point.getY();
        if(x < 0 || x >= map[0].length || y < 0 || y >= map.length){
            return ' ';
        }
        return map[y][x];
    }

}
