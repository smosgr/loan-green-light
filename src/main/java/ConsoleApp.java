import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleApp {

    OutputCalculator calc = new OutputCalculator();
    private InputValidator inputValidator = new InputValidator();
    private CsvParser csvParser = new CsvParser();
    private InputStream data;


    ConsoleApp() {
    }


    public void callValidators() {
        String input;
        boolean amountValidation;
        String[] parts;
        double[] availability;
        boolean appValidation = true;

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

                        availability = csvParser.parseDatafile(data);
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

        System.out.println("Type in the app name, datafile to be parsed and requested amount. Example 'cmd> quote.exe market.csv 1500'. ('Q' or 'q' to exit)\n");

        System.out.print("cmd >  ");
    }

    public String readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}