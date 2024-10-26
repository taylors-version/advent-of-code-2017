package com.ben.aoc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3 {

    private final Map<Point<Integer>, Integer> datastore = new HashMap<>();

    public long puzzle1(int input) {
        CartesianIntPoint location = getLocation(input);

        return location.manhattanDistance(new CartesianIntPoint(0,0));
    }

    public long puzzle2(int input) {

        return getValueAbove(input);
    }

    private CartesianIntPoint getLocation(int input){
        CartesianIntPoint location = new CartesianIntPoint(0,0);

        int movesBeforeTurn = 1;
        int turnCount = 0;
        int i = 1;
        int moves = 0;
        Direction dir = new Direction(Direction.Dir.RIGHT);
        while (i < input){
            while(moves < movesBeforeTurn && i < input){
                i++;
                location = (CartesianIntPoint) location.getByDirection(dir);
                moves ++;
            }
            dir = dir.rotateAntiClockwise();
            turnCount++;
            if(turnCount == 2){
                movesBeforeTurn++;
                turnCount = 0;
            }
            moves = 0;

        }
        return location;
    }

    private int getValueAbove(int input){
        CartesianIntPoint location = new CartesianIntPoint(0,0);
        datastore.put(location, 1);
        int movesBeforeTurn = 1;
        int turnCount = 0;
        int i = 1;
        int moves = 0;
        Direction dir = new Direction(Direction.Dir.RIGHT);
        while (i < input){
            while(moves < movesBeforeTurn && i < input){
                location = (CartesianIntPoint) location.getByDirection(dir);
                i = getValue(location);
                datastore.put(location, i);
                moves ++;
            }
            dir = dir.rotateAntiClockwise();
            turnCount++;
            if(turnCount == 2){
                movesBeforeTurn++;
                turnCount = 0;
            }
            moves = 0;

        }
        return i;
    }

    private int getValue(CartesianIntPoint location){
        List<Point<Integer>> neighbours = location.allNeighbours(true);
        int result = 0;
        for(Point<Integer> coord : neighbours){
            result+=datastore.getOrDefault(coord, 0);
        }
        return result;
    }
}
