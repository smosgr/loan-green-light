public class InputValidator {

    public static final int MIN_ALLOWED_AMOUNT = 1000;
    public static final int MAX_ALLOWED_AMOUNT = 15000;
    public static final int ALLOWED_INCREMENTS = 100;

    InputValidator() {

    }

    public boolean validateAppName(String input) {

        if (input.matches("Q") || input.matches("q")) {
            System.out.println("Thank you and goodbye!");
            return false;
        } else if (input.matches("quote.exe")) {
            System.out.println("'" + input + "' is a correct app name. Make sure you pass the data file and the required loan amount. \n");
            return true;
        } else
            System.out.println("'" + input + "' is not the correct application name. You may want to use 'quote.exe' instead.");
        return true;
    }

    public boolean validateRequestedAmount(int amount) {

        if ((amount % ALLOWED_INCREMENTS == 0.0) && (amount >= MIN_ALLOWED_AMOUNT && amount <= MAX_ALLOWED_AMOUNT)) {
            return true;
        } else
            System.out.println("Only increments of £100 allowed. Requested amount should be between 1000 to 15000 inclusive.");
        return false;
    }

    public boolean validateDataFilename(String filename) {

        if (filename.equals("market.csv")) {
            System.out.println("'" + filename + "' is found.\n");
            return true;
        } else {
            System.out.println("'" + filename + "' was not found. Please try again with 'market.csv'.\n");
            return false;
        }
    }

}