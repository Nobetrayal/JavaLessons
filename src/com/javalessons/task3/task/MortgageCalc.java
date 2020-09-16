package com.javalessons.task3.task;


public class MortgageCalc {

    public static void main(String[] args) {

        Calculator calc = new Calculator(100000, 30,  0.09D, 100);
        double paymentSum = calc.calcPaymentSum();
        calc.setPayment(paymentSum);
        System.out.println("Monthly payment:" + paymentSum);
        calc.calculateAndPrintPaymentSplitUp();


    }
}
