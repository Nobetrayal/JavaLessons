package com.javalessons.task3.task;

public class Calculator {
    private static final int MONTHS = 12;
    private int loanAmount = 0;
    private int years = 0;
    private double interestRate = 0;
    private int extraPayment = 0;
    private double interestRatePerMonth = 0;
    private double payment = 0;


    public Calculator(int loanAmount, int years, double interestRate) {
        this(loanAmount, years, interestRate, 0);

    }

    public Calculator(int loanAmount, int years, double interestRate, int extraPayment) {
        this.loanAmount = loanAmount;
        this.years = years;
        this.interestRate = interestRate;
        this.extraPayment = extraPayment;
        this.interestRatePerMonth = interestRate / MONTHS;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double calcPaymentSum() {

        return (loanAmount * interestRatePerMonth) / (1 - (Math.pow((1 + interestRatePerMonth), -1 * years * MONTHS)));

    }

    public void calculateAndPrintPaymentSplitUp() {
        int currentMonth = 1;
        double startingBalance = loanAmount;
        double interest = 0;
        double principal = 0;
        double endingBalance = 0;
        double totalInterest = 0;
        double currentPayment = 0;

        double totalPaymentPerMonth = payment + extraPayment;

        System.out.println("MONTH,  STARING_BALANCE,  PAYMENT,  INTEREST,  PRINCIPAL,  ENDING_BALANCE,  TOTAL_INTEREST");

        while (currentMonth <= years * MONTHS) {

            if (startingBalance < totalPaymentPerMonth) {

                interest = 0;
                currentPayment = startingBalance + interest;
                principal = startingBalance;

                endingBalance = startingBalance - principal;
                totalInterest = totalInterest + interest;

                System.out.printf("%d, %15.2f, %12.2f, %8.2f, %8.2f, %15.2f, %15.2f%n", currentMonth, startingBalance, currentPayment,
                        interest, principal, endingBalance, totalInterest);

                break;
            } else {

                currentPayment = totalPaymentPerMonth;
                interest = startingBalance * interestRatePerMonth;
                principal = currentPayment - interest;

                endingBalance = startingBalance - principal;
                totalInterest = totalInterest + interest;

                System.out.printf("%d, %15.2f, %12.2f, %8.2f, %8.2f, %15.2f, %15.2f%n", currentMonth, startingBalance, currentPayment,
                        interest, principal, endingBalance, totalInterest);
            }

            currentMonth++;
            startingBalance = endingBalance;

        }

    }

}
