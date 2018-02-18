import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleApp {

    ConsoleApp() {
    }

    private static String parseCsv(String part) {
        System.out.println(part + "---------------------------------------------------");
        return "";
    }

    private static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public void setupConsole() {
        String input = "";
        String[] parts;

        while (!input.equals("Q") || (!input.equals("q"))) {

            System.out.print("cmd>  ");

            input = readFromConsole();
            parts = input.split(" ");

            if (validateAppName(parts[0]) && validateRequestedAmount(parts[2])) {
                try {
                    validateDataFilename(parts[1]);

                } catch (ArrayIndexOutOfBoundsException e) {
                    e.getMessage();
                }
            }
        }

        System.exit(0);
    }

    public boolean validateRequestedAmount(String part) {
        int amount = Integer.parseInt(part);

        if ((amount % 100 == 0.0) && (amount > 1000 && amount < 15000)) {
            return true;
        } else
            System.out.println("Only increments of £100 allowed. Request amount should be between 1000 to 15000 inclusive.");
            return false;
    }

    public String readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
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

    public void validateDataFilename(String data) {
        if (data.equals("market.csv")) {
            //Import file 'market.csv' here
            InputStream inputStream = this.getClass().getResourceAsStream("market.csv");

            try {
                String in = readFromInputStream(inputStream);
                System.out.println(in);

            } catch (IOException io) {
                io.getMessage();
            }
        }
    }

}