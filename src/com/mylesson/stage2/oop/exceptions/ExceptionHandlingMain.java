package com.mylesson.stage2.oop.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingMain {


    public static void main(String[] args) {
        try {
            doEverything();
        } catch (InvalidInputParamException e) {
            System.out.println("NPE");
            Throwable[] suppressed = e.getSuppressed();
            e.printStackTrace();
        }
    }

    private static void doEverything() {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        do {

            try(PrintWriter writer = new PrintWriter(new FileWriter("out.txt"))) {

                System.out.println("Enter numerator");
                int numerator = scanner.nextInt();

                System.out.println("Enter denominator");
                int denominator = scanner.nextInt();

//                System.out.println(divide(numerator, denominator));
//                safeToFile(divide(numerator, denominator));
                //writer = new PrintWriter(new FileWriter("out.txt"));
                writer.println("result = " + divide(numerator, denominator));

                writer.close();
                continueLoop = false;
            } catch (ArithmeticException | InputMismatchException e) {
                System.out.println("Exception " + e);
                scanner.nextLine();
                System.out.println("Only non-zero int parameters allowed");

            } catch (IOException e) {
                System.out.println("Unable to open file");
                e.printStackTrace();
            } catch (IndexOutOfBoundsException e) {

                throw new InvalidInputParamException("Index out of bound. thrown in doEveryThing " + e);

            }finally {
                System.out.println("Finally block called");
//                if (writer != null){
//                    writer.close();
//                }

            }

        } while (continueLoop);
    }

    private static int divide(int numerator, int denominator) throws ArithmeticException, NullPointerException {

        return numerator / denominator;
    }

    public static void safeToFile(int result) throws IOException {

        PrintWriter writer = new PrintWriter(new FileWriter("out.txt"));
        writer.println("result = " + result);
        writer.close();
    }

}
