package com.ben.aoc;


import java.util.*;

public class Day22 {

    public long puzzle1(List<String> input) {
        long infections = 0;
        Set<IntPoint> infected = new HashSet<>();
        for (int y = 0; y < input.size(); y++){
            String line = input.get(y);
            for(int x = 0; x < line.length(); x++){
                if(line.charAt(x) == '#'){
                    infected.add(new IntPoint(x,y));
                }
            }
        }
        IntPoint virus = new IntPoint(input.size() / 2, input.size() / 2);
        Direction dir = new Direction('u');

        for(int i = 0; i < 10000; i++){
            boolean current = infected.contains(virus);
            dir = current ? dir.rotateClockwise() : dir.rotateAntiClockwise();
            if (current){
                infected.remove(virus);
            }else {
                infections++;
                infected.add(virus);
            }
            virus = (IntPoint) virus.getByDirection(dir);
        }

        return infections;
    }

    public long puzzle2(List<String> input) {
        long infections = 0;
        HashMap<IntPoint, Character> states = new HashMap<>();
        for (int y = 0; y < input.size(); y++){
            String line = input.get(y);
            for(int x = 0; x < line.length(); x++){
                if(line.charAt(x) == '#'){
                    states.put(new IntPoint(x,y), 'I');
                }
            }
        }
        IntPoint virus = new IntPoint(input.size() / 2, input.size() / 2);
        Direction dir = new Direction('u');

        for(int i = 0; i < 10000000; i++){
            char state = states.getOrDefault(virus, 'C');
            char nextState = ' ';
            switch (state){
                case 'C':
                    dir = dir.rotateAntiClockwise();
                    nextState = 'W';
                    break;
                case 'W':
                    nextState = 'I';
                    infections++;
                    break;
                case 'I':
                    dir = dir.rotateClockwise();
                    nextState = 'F';
                    break;
                case 'F':
                    dir = dir.rotateClockwise().rotateClockwise();
                    nextState = 'C';
                    break;
            }
            states.put(virus, nextState);
            virus = (IntPoint) virus.getByDirection(dir);
        }

        return infections;
    }

}
