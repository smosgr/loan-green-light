import java.io.IOException;
import java.io.InputStream;

public class InputValidator {

    ConsoleApp consoleApp; //TODO: remove when parser class is added

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

    public boolean validateRequestedAmount(String part) {
        int amount = Integer.parseInt(part);

        if ((amount % 100 == 0.0) && (amount >= 1000 && amount <= 15000)) {
            return true;
        } else
            System.out.println("Only increments of £100 allowed. Requested amount should be between 1000 to 15000 inclusive.");
        return false;
    }

    public void validateDataFilename(String data) {
        if (data.equals("market.csv")) {
            //Import file 'market.csv' here
            InputStream inputStream = this.getClass().getResourceAsStream("market.csv");

            try {
                //TODO: move to parser class
                String in = consoleApp.readFromInputStream(inputStream);
                System.out.println(in);

            } catch (IOException io) {
                io.getMessage();
            }
        }
    }


}