import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleApp {

    private InputValidator inputValidator = new InputValidator();
    private CsvParser csvParser = new CsvParser();
    private InputStream data;


    ConsoleApp() {
    }


    public void callValidators() {
        String input;
        String[] parts;
        boolean appValidation = true;
        boolean amountValidation;

        while (appValidation) {

            setupConsole();

            input = readFromConsole();

            parts = input.split(" ");

            try {
                appValidation = inputValidator.validateAppName(parts[0]);

                if (appValidation) {

                    int requestedAmount = Integer.parseInt(parts[2]);

                    amountValidation = inputValidator.validateRequestedAmount(requestedAmount);

                    if (amountValidation && inputValidator.validateDataFilename(parts[1])) {

                        try {

                            data = this.getClass().getResourceAsStream(parts[1]);
                        } catch (InputMismatchException e) {
                            e.getMessage();

                        }

                        double[] availability = csvParser.parseDatafile(data);

                        OutputCalculator calc = new OutputCalculator();
                        calc.calculateInterest(availability, requestedAmount);


                    } else
                        continue;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                e.getMessage();
            }
        }
        System.exit(1);
    }

    private void setupConsole() {
        System.out.print("cmd>  ");
    }

    public String readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}