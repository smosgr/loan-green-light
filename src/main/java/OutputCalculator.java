import java.text.DecimalFormat;

public class OutputCalculator {

    public static final double YEARS_IN_MONTHS = 36;

    public void calculateInterest(double[] availability, int requestedAmount) { //principal= 1000, years=3, rate = 0.054444285714286;

        double rate = availability[0];
        double principal = availability[1];

        double compoundInterest = principal * Math.pow((1 + rate), YEARS_IN_MONTHS);
        double totalRepayment = compoundInterest * principal;

        printOutput(principal, rate, compoundInterest, totalRepayment, requestedAmount);
    }

    public void printOutput(double principal, double rate, double compoundInterest, double totalRepayment, int requestedAmount) {
        System.out.println("\n");
        System.out.println("Requested amount: " + "£" + requestedAmount);
        System.out.println("Rate: " + new DecimalFormat("##.##").format(rate) + "%"); // <---- TODO: FIX PROVIDED RATE
        System.out.println("Monthly repayment: " + "£" + 345); //<--------CHANGE THAT
        System.out.println("Total repayment: " + "£" + totalRepayment); //<-------- CHANGE THAT
        System.out.println("The Compound Interest is : " + compoundInterest);
    }

    //TODO: FIX CALCULATION
}