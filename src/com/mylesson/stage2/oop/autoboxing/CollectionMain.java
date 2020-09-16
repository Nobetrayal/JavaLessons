package com.mylesson.stage2.oop.autoboxing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionMain {
    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        list.add(Integer.valueOf(1)); // действие по умолчанию. boxing

        Integer integ = 56;
        int n = integ.intValue(); // unBoxing.

        String[] colors = {"yellow", "green", "blue"};
        LinkedList<String> ll = new LinkedList<>(Arrays.asList(colors));
        ll.add("black");
        colors = ll.toArray(new String[ll.size()]);

    }



}
