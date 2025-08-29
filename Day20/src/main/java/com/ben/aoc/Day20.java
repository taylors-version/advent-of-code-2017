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
        int minDistance = 0;
        Set<Particle> set;
        List<Particle> duplicates;

        List<Particle> particles = new ArrayList<>();
        for(String line : input){
            particles.add(new Particle(line));
        }
        while(minDistance < 1000) {
            set = new HashSet<>();
            duplicates = new ArrayList<>();
            for (Particle p : particles) {
                p.tick();
                if(set.contains(p)){
                    duplicates.add(p);
                }else{
                    set.add(p);
                }
            }
            if(duplicates.isEmpty()){
                minDistance = minDistance(particles);
            }else{
                minDistance = 0;
                particles.removeAll(duplicates);
            }
        }
        return particles.size();
    }

    private int minDistance(List<Particle> particles){
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < particles.size() - 1; i++){
            minDistance = Math.min(minDistance, particles.get(i).minDistance(particles.subList(i+1, particles.size())));
        }

        return minDistance;
    }


}
