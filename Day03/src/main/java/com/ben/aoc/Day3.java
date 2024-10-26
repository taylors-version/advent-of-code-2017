package com.ben.aoc;

public class Day3 {

    public long puzzle1(int input) {
        CartesianIntPoint location = getLocation(input);

        return location.manhattanDistance(new CartesianIntPoint(0,0));
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
}
