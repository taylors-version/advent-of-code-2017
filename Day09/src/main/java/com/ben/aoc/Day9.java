package com.ben.aoc;

public class Day9 {

    public long puzzle1(String input) {
        long score = 0;
        int depth = 1;
        boolean inTrash = false;
        boolean skip = false;
        for(char c : input.toCharArray()){
            if(!skip) {
                if (!inTrash) {
                    switch (c) {
                        case '{':
                            score += depth;
                            depth++;
                            break;
                        case '}':
                            depth--;
                            break;
                        case '<':
                            inTrash = true;
                            break;
                    }
                } else {
                    switch (c) {
                        case '>':
                            inTrash = false;
                            break;
                        case '!':
                            skip = true;
                            break;
                    }
                }
            }else{
                skip = false;
            }
        }
        return score;
    }

    public long puzzle2(String input) {
        long trashChars = 0;
        boolean inTrash = false;
        boolean skip = false;
        for(char c : input.toCharArray()){
            if(!skip) {
                if (!inTrash) {
                    if (c =='<') {
                        inTrash = true;
                    }
                } else {
                    switch (c) {
                        case '>':
                            inTrash = false;
                            break;
                        case '!':
                            skip = true;
                            break;
                        default:
                            trashChars++;
                    }
                }
            }else{
                skip = false;
            }
        }
        return trashChars;
    }

}
