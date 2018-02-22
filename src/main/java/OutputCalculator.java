public class OutputCalculator {

    public static final double YEARS_IN_MONTHS = 36;

    public void calculateInterest(double[] availability, int requestedAmount) { //principal= 1000, years=3;

        //TODO: FIX CALCULATION

        double rate = availability[0]; // SHOULD BE 0.077857142857143 aka 7.785714285714286 aka 7.8%
        double principal = availability[1];


        if (requestedAmount > principal) {

            System.out.println("Sorry, we are not able to provide you with "
                    + "the requested amount "
                    + " ("
                    + "£" + requestedAmount
                    + ") "
                    + " at this time. Please try again later");
        } else {
            double compoundInterest = Math.pow(1.0 + rate, YEARS_IN_MONTHS/12);


            double totalRepayment = requestedAmount * compoundInterest;

            double monthlyRepayment = totalRepayment / YEARS_IN_MONTHS;

            printOutput(monthlyRepayment, compoundInterest, totalRepayment, requestedAmount);

        }
        }

    public void printOutput(double monthlyRepayment, double compoundInterest, double totalRepayment, int requestedAmount) {
        System.out.println("Requested amount: " + "£" + requestedAmount);
        System.out.printf("Rate: " + "%.1f", compoundInterest);
        System.out.println("%");
        System.out.println("Monthly repayment: " + "£" + monthlyRepayment);
        System.out.println("Total repayment: " + "£" + totalRepayment);
    }

}