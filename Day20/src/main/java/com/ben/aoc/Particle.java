package com.ben.aoc;

import org.javatuples.Triplet;

import java.util.Collection;
import java.util.Objects;

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
        String[] regions = input.split(", ");
        String[] positions = regions[0].substring(3, regions[0].length()-1).split(",");
        String[] velocity = regions[1].substring(3, regions[1].length()-1).split(",");
        String[] acceleration = regions[2].substring(3, regions[2].length()-1).split(",");

        this.xPos = Integer.parseInt(positions[0]);
        this.yPos = Integer.parseInt(positions[1]);
        this.zPos = Integer.parseInt(positions[2]);
        this.xVel = Integer.parseInt(velocity[0]);
        this.yVel = Integer.parseInt(velocity[1]);
        this.zVel = Integer.parseInt(velocity[2]);
        this.xAcc = Integer.parseInt(acceleration[0]);
        this.yAcc = Integer.parseInt(acceleration[1]);
        this.zAcc = Integer.parseInt(acceleration[2]);
    }

    public void tick(){
        this.xVel+=this.xAcc;
        this.yVel+=this.yAcc;
        this.zVel+=this.zAcc;
        this.xPos+=this.xVel;
        this.yPos+=this.yVel;
        this.zPos+=this.zVel;
    }

    public Triplet<Integer, Integer, Integer> getPos(){
        return new Triplet<>(xPos, yPos, zPos);
    }

    public int distance(Particle p){
        return Math.abs(this.xPos - p.xPos) + Math.abs(this.yPos - p.yPos) + Math.abs(this.zPos - p.zPos);
    }

    public int minDistance(Collection<Particle> particles){
        int minDistance = Integer.MAX_VALUE;
        for(Particle p : particles){
            minDistance = Math.min(minDistance, distance(p));
        }
        return minDistance;
    }

    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if(!(o instanceof Particle p)){
            return false;
        }
        return this.xPos == p.xPos && this.yPos == p.yPos & this.zPos == p.zPos;
    }

    @Override
    public int hashCode(){
        return Objects.hash(xPos, yPos, zPos);
    }
}
