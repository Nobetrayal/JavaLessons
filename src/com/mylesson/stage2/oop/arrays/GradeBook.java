package com.mylesson.stage2.oop.arrays;

import java.util.Arrays;

public class GradeBook {
    public static void main(String[] args) {

        int[][] gradesArray = {{89, 96, 70},
                {68, 87, 90},
                {94, 100, 90},
                {100, 81, 82},
                {83, 65, 85},
                {78, 87, 65},
                {85, 75, 83},
                {91, 94, 100},
                {76, 72, 84},
                {87, 93, 73}};


        System.out.println("minimal grade " + calcMin(gradesArray));

        varArgs();
        processArrays();

    }


    private static int calcMin(int[][] grades) {

        int min = 100;
        for (int[] row: grades) {
            for (int value:row) {

                if (value < min){
                    min = value;
                }

            }

        }
        return min;
    }

    private static void varArgs(){
        double a = 0.56;
        double b = 1.92;
        double c = 3.45;
        double d = 5.01;

        System.out.println("average of 2 is " + calcAverage(a, b));
        System.out.println("average of 3 is " + calcAverage(a, b, c));
        System.out.println("average of 4 is " + calcAverage(a, b, c, d));
    }

    private static double calcAverage(double... args){

        double sum = 0;

        for (double i:args) {
            sum = sum + i;
        }

        return sum/args.length;

    }

    private static void processArrays(){

        double[] doubleArray = {8.9,5.65,8.12,45,77.1};

        Arrays.sort(doubleArray);
        System.out.println(Arrays.toString(doubleArray));

        int[] filledArray = new int[7];
        Arrays.fill(filledArray, 7);
        System.out.println(Arrays.toString(filledArray));

        int[] intArray = {1,2,3,4,5,6,7};
        int[] arrayCopy = new int[10];
        System.arraycopy(intArray, 0, arrayCopy, 0, intArray.length);
        System.out.println(Arrays.toString(arrayCopy));

    }

}