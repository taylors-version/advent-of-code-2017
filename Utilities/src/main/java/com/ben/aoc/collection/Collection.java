package com.ben.aoc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collection {

    public static List<String> sliding(String string, Integer size, Integer step){
        List<String> result = new ArrayList<>();
        int position = 0;

        while(position + size <= string.length()){
            result.add(string.substring(position, position + size));
            position+=step;
        }
        if(string.length() % step != 0){
            result.add(string.substring(string.length() - (step - 1)));
        }

        return result;
    }

    public static List<String> sliding(String string, Integer size){
        return sliding(string, size, 1);
    }

    public static <T> List<List<T>> sliding(List<T> list, Integer size, Integer step){
        List<List<T>> result = new ArrayList<>();
        int position = 0;

        while(position + size <= list.size()){
            List<T> slide = new ArrayList<>();
            for(int i = position; i < position + size; i++) {
                slide.add(list.get(i));
            }
            result.add(slide);
            position+=step;
        }
        if(list.size() % step != 0){
            List<T> slide = new ArrayList<>();
            for(int i = list.size() - (step - 1); i < list.size(); i++){
                slide.add(list.get(i));
            }
            result.add(slide);
        }

        return result;
    }

    public static <T> List<List<T>> sliding(List<T> list, Integer size){
        return sliding(list, size, 1);
    }

    public static <T> List<List<T>> sliding(T[] array, Integer size, Integer step){
        List<List<T>> result = new ArrayList<>();
        int position = 0;

        while(position + size <= array.length){
            List<T> slide = new ArrayList<>(Arrays.asList(array).subList(position, position + size));
            result.add(slide);
            position+=step;
        }
        if(array.length % step != 0){
            List<T> slide = new ArrayList<>(Arrays.asList(array).subList(array.length - (step - 1), array.length));
            result.add(slide);
        }

        return result;
    }

    public static <T> List<List<T>> sliding(T[] array, Integer size) {
        return sliding(array, size, 1);
    }

}
