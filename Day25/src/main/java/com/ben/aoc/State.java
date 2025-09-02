package com.ben.aoc;

public class State {
    boolean falsePrint;
    boolean truePrint;
    int falseDirection;
    int trueDirection;
    char falseNext;
    char trueNext;

    public State(boolean falsePrint, boolean truePrint, int falseDirection, int trueDirection, char falseNext, char trueNext) {
        this.falsePrint = falsePrint;
        this.truePrint = truePrint;
        this.falseDirection = falseDirection;
        this.trueDirection = trueDirection;
        this.falseNext = falseNext;
        this.trueNext = trueNext;
    }

    public boolean getPrint(boolean read){
        return read ? truePrint : falsePrint;
    }

    public int getDirection(boolean read){
        return read ? trueDirection : falseDirection;
    }

    public char getNext(boolean read){
        return  read ? trueNext : falseNext;
    }
}
