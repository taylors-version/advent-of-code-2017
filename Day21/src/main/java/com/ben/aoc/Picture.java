package com.ben.aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Picture {
    char[][] grid;
    Picture output;

    public Picture(String input, Picture output){
        String[] lines = input.split("/");
        grid = new char[lines.length][];
        for(int i = 0; i < lines.length; i++){
            grid[i] = lines[i].toCharArray();
        }
        this.output = output;
    }

    public Picture(String input){
        this(input, null);
    }

    public Picture(List<Picture> pictures){
        int sqrt = (int) Math.sqrt(pictures.size());
        int internalSide = pictures.get(0).grid.length;
        int side = sqrt * internalSide;
        grid = new char[side][side];
        int iCounter = -1 * sqrt;
        for(int i = 0; i < side; i++){
            if(i % internalSide == 0){
                iCounter+=sqrt;
            }
            int jCounter = -1;
            for (int j = 0; j < side; j++){
                if(j % internalSide == 0){
                    jCounter++;
                }
                Picture p = pictures.get(iCounter + jCounter);
                grid[i][j] = p.grid[i%p.grid.length][j%p.grid.length];
            }
        }

    }

    public boolean matches(Picture picture){
        if(this.grid.length != picture.grid.length){
            return false;
        }
        char[][] gridB = picture.grid;
        return compareRotations(grid, gridB) || compareRotations(grid, Util.flipMatrixEW(gridB)) || compareRotations(grid, Util.flipMatrixNS(gridB));
    }

    public int numberOfOn(){
        int ons = 0;
        for(char[] line : grid){
            for(char c : line){
                if (c == '#'){
                    ons++;
                }
            }
        }
        return ons;
    }

    public List<Picture> split(){
        List<Picture> pictures = new ArrayList<>();

        if(grid.length % 2 == 0){
            for(int i = 0; i < grid.length; i+=2){
                for(int j = 0; j < grid.length; j+=2) {
                    pictures.add(new Picture(String.valueOf(grid[i][j]) + grid[i][j + 1] + '/' + grid[i + 1][j] + grid[i + 1][j + 1]));
                }
            }
        }else{
            for(int i = 0; i < grid.length; i+=3){
                for(int j = 0; j < grid.length; j+=3){
                    pictures.add(new Picture(String.valueOf(grid[i][j]) + grid[i][j + 1] + grid[i][j + 2] + '/'
                            + grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] + '/'
                            + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2]));
                }
            }
        }

        return pictures;
    }

    private boolean compareRotations(char[][] gridA, char[][] gridB){
        return gridCompare(gridA, gridB) || gridCompare(gridA, Util.rotateMatrix(gridB)) || gridCompare(gridA, Util.rotateMatrixTwice(gridB)) || gridCompare(gridA, Util.rotateMatrixAntiClock(gridB));
    }

    private boolean gridCompare(char[][] gridA, char[][] gridB){
        if(gridA.length != gridB.length){
            return false;
        }
        for(int i = 0; i < gridA.length; i++){
            if(!Arrays.equals(gridA[i], gridB[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Picture p)){
            return false;
        }
        return gridCompare(grid, p.grid);
    }

    @Override
    public int hashCode(){
        return Objects.hash((Object[]) grid);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (char[] c : grid){
            sb.append(c);
            sb.append("\n");
        }
        return sb.toString();
    }
}
