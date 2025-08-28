package com.ben.aoc;

public class Particle {
    int xPos;
    int yPos;
    int zPos;
    int xVel;
    int yVel;
    int zVel;
    int xAcc;
    int yAcc;
    int zAcc;


    public Particle(String input){
        String[] numbers = input.split("\\D+");

        this.xPos = Integer.parseInt(numbers[1]);
        this.yPos = Integer.parseInt(numbers[2]);
        this.zPos = Integer.parseInt(numbers[3]);
        this.xVel = Integer.parseInt(numbers[4]);
        this.yVel = Integer.parseInt(numbers[5]);
        this.zVel = Integer.parseInt(numbers[6]);
        this.xAcc = Integer.parseInt(numbers[7]);
        this.yAcc = Integer.parseInt(numbers[8]);
        this.zAcc = Integer.parseInt(numbers[9]);
    }
}
