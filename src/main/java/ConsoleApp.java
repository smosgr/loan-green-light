import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleApp {

    ConsoleApp() {
    }

    public void setupConsole() {
        String input = "";
        String[] parts;

        while (!input.equals("Q")) {

            System.out.print("cmd>  ");

            input = readFromConsole();
            parts = input.split(" ");

            if (validateAppName(parts[0])) {
                try {
                    validateDataFilename(parts[1]);
                } catch (IOException e) {
                    e.getMessage();
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.getMessage();
                }
            }
        }

        System.exit(0);
    }


    public String readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public boolean validateAppName(String input) {

        if (input.matches("Q")) {
            System.out.println("Thank you and goodbye!");

            return false;

        } else if (input.matches("quote.exe")){
            System.out.println("'" + input + "' app is running...\n");

            return true;
        }else
            System.out.println("'" + input + "' is not the correct application name. You may want to use 'quote.exe' instead.");
            return true;
    }


    public void validateDataFilename(String data) throws IOException {
        if (data.equals("market.csv")) {
            //Import file 'market.csv' here
            Class clazz = CalculationSystem.class;
            InputStream inputStream = clazz.getResourceAsStream("market.csv");
            String in = readFromInputStream(inputStream);
            System.out.println(in);
        }
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

}