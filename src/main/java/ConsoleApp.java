import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleApp {

    InputValidator inputValidator = new InputValidator();
    CsvParser csvParser = new CsvParser();
    InputStream data;

    ConsoleApp() {
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

                    if (amountValidation && inputValidator.validateDataFilename(parts[1])) {
                        try {
                            data = this.getClass().getResourceAsStream(parts[1]);
                        } catch (InputMismatchException e) {
                            e.getMessage();
                        }

                        csvParser.parseDatafile(data);

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