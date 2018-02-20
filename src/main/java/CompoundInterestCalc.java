import java.text.DecimalFormat;

public class CompoundInterestCalc {

    public void calculateInterest(double principal, int years, double rate) { //principal= 1000, years=3, rate = 0.054444285714286;

        double compoundInterest = principal * Math.pow((1 + rate), years);
        double totalRepayment = compoundInterest * principal;

        printOutput(principal, rate, compoundInterest, totalRepayment);
    }

    public void printOutput(double principal, double rate, double compoundInterest, double totalRepayment) {
        System.out.println("/n");
        System.out.println("Requested amount: " + "£" + principal);
        System.out.println("Rate: " + new DecimalFormat("##.#").format(rate) + "%");
        System.out.println("Monthly repayment: " + "£" + 345); //<--------CHANGE THAT
        System.out.println("Total repayment: " + "£" + totalRepayment); //<-------- CHANGE THAT
        System.out.println("The Compound Interest is : " + compoundInterest);
    }
}