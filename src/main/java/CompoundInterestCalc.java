import java.util.Scanner;

public class CompoundInterestCalc {

    static int LENDING_PERIOD_IN_MONTHS = 36;
    double amount;
    double rate;
    double year;


    CompoundInterestCalc() {
    }

    public void calculateInterest() {

        System.out.println("This program, with user input, computes interest.\n" +
                "It allows for multiple computations.\n" +
                "User will input initial cost, interest rate and number of years.");

        Scanner keyboard = new Scanner(System.in);

        System.out.println("What is the initial cost?");
        amount = keyboard.nextDouble();

        System.out.println("What is the interest rate?");
//        rate = keyboard.nextDouble();
        rate = 0.054444285714286;

        System.out.println("How many years?");
        year = keyboard.nextInt(); // static int LENDING_PERIOD_IN_MONTHS = 36; aka 3 years.


        for (int x = 1; x < year; x++) {
            String go = "n";
            System.out.println("For " + year + " years an initial " + amount
                    +" cost compounded at a rate of " + rate + " will grow to " + amount);


            amount = amount * Math.pow(1.0 + rate, year);


            do {
                System.out.println("Continue Y/N");
                go = keyboard.nextLine();
            } while (go.equals("Y") || go.equals("y"));

        }
    }
}