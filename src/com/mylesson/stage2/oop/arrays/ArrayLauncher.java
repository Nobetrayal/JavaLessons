package com.mylesson.stage2.oop.arrays;

import java.util.Scanner;

public class ArrayLauncher {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myArray = new int[10];
//        int[] myArray = {0,100,200,300,400,500,600,700,800,900};

        for (int j = 0; j < myArray.length; j++) {

            myArray[j] = scanner.nextInt();

        }


        for (int i = 0; i < myArray.length; i++) {

            System.out.println("Element [" + i + "] = " + myArray[i]);

        }

    }

    private static int[] sort(int[] array) {

//        int[] newArray = new int[array.length];
//
//        for(int i = 0; i< array.length; i++){
//            newArray[i] = array[i];
//
//        }

 //       int[] newArray = Arrays.copyOf(array, array.length);
//
//        return newArray;
        // Сортировка пузырьком.
        // 10,5,16,4
        // 5,10,16,4
        // 5,10,4,16
        // 5,4,10,16З
        // 4,5,10,16
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }

        return array;
    }



}
