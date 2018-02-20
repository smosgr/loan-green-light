import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleApp {

    InputValidator inputValidator = new InputValidator();

    ConsoleApp() {
    }

    public static String readFromInputStream(InputStream inputStream)
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
        String input;
        String[] parts;
        boolean appValidation = true;
        boolean amountValidation;

        while (appValidation) {

            System.out.print("cmd>  ");
            input = readFromConsole();
            parts = input.split(" ");

            try {
                appValidation = inputValidator.validateAppName(parts[0]);

                if (appValidation) {
                    amountValidation = inputValidator.validateRequestedAmount(parts[2]);

                    if (appValidation && amountValidation) {
                        //TODO: PARSE FILE HERE
                        inputValidator.validateDataFilename(parts[1]);
                    } else
                        continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                e.getMessage();
            }

        }

        System.exit(1);
    }

    public String readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}