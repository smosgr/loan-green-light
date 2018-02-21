public class OutputCalculator {

    public static final double YEARS_IN_MONTHS = 36;

    public void calculateInterest(double[] availability, int requestedAmount) { //principal= 1000, years=3;

        //TODO: FIX CALCULATION

        double rate = availability[0]; // SHOULD BE 0.077857142857143 aka 7.785714285714286 aka 7.8%
        System.out.println("----------------------------" + rate);
        double principal = availability[1];

        double compoundInterest = Math.pow(1.0 + rate, YEARS_IN_MONTHS) - 1.0;

        double totalRepayment = principal * compoundInterest;

        double monthlyRepayment = totalRepayment / YEARS_IN_MONTHS;

        printOutput(monthlyRepayment, compoundInterest, totalRepayment, requestedAmount);

        //TODO: CONFUSED REQUESTED MONEY WITH AVAILABLE MONEY?
    }

    public void printOutput(double monthlyRepayment, double compoundInterest, double totalRepayment, int requestedAmount) {
        System.out.println("Requested amount: " + "£" + requestedAmount);
        System.out.printf("Rate: " + "%.1f", compoundInterest);
        System.out.println("%");
        System.out.println("Monthly repayment: " + "£" + monthlyRepayment);
        System.out.println("Total repayment: " + "£" + totalRepayment);
    }

}