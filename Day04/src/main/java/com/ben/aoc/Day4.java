package com.ben.aoc;

import java.util.*;

public class Day4 {

    public long puzzle1(List<String> input) {
        int result = 0;
        for(String passphrase : input){
            if(isValid(passphrase))
                result++;
        }
        return result;
    }

    private boolean isValid(String passphrase){
        Set<String> words = new HashSet<>();
        for(String word : passphrase.split(" ")){
            if(!words.add(word))
                return false;
        }
        return true;
    }


}
