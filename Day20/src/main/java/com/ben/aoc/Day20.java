package com.ben.aoc;


import java.util.*;

public class Day20 {

    public long puzzle1(List<String> input) {
        long result = 0;
        int minAccel = Integer.MAX_VALUE;

        for (int i = 0; i < input.size(); i++){
            Particle p = new Particle(input.get(i));
            int accel = Math.abs(p.xAcc) + Math.abs(p.yAcc) + Math.abs(p.zAcc);
            if (accel < minAccel){
                minAccel = accel;
                result = i;
            }
        }

        return result;
    }

    public long puzzle2(List<String> input) {
        return 0;
    }


}
