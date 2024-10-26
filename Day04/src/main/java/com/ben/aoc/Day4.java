package com.ben.aoc;

import com.ben.aoc.collection.Collection;

import java.util.*;

public class Day4 {

    public long puzzle1(List<String> input) {
        int result = 0;
        for(String passphrase : input){
            if(containsNoDuplicates(passphrase))
                result++;
        }
        return result;
    }

    public long puzzle2(List<String> input) {
        int result = 0;
        for(String passphrase : input){
            if(containsNoAnagrams(passphrase))
                result++;
        }
        return result;
    }

    private boolean containsNoDuplicates(String passphrase){
        Set<String> words = new HashSet<>();
        for(String word : passphrase.split(" ")){
            if(!words.add(word))
                return false;
        }
        return true;
    }

    private boolean containsNoAnagrams(String passphrase){
        List<String> words = List.of(passphrase.split(" "));
        for(List<String> pair : Collection.combinationsUtil(words, 2)){
            String word1 = Arrays.toString(pair.get(0).chars().sorted().toArray());
            String word2 = Arrays.toString(pair.get(1).chars().sorted().toArray());
            if(word1.equals(word2))
                return false;
        }

        return true;
    }

}
