import java.io.InputStream;
import java.util.Scanner;

public class CsvParser {

    private static double rates = 0.0;
    private static int totalOfferedAmount = 0;
    private static int records = 0;
    private static String pattern = "[a-zA-Z]*";

    public CsvParser() {
    }


    public static double[] parseDatafile(InputStream inputStream) {

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()) {

            String line = scanner.next();
            String[] values = line.split(",");

            if (!(values[1].matches(pattern)) && !(values[2].matches(pattern))) {

                rates = rates + Double.parseDouble(values[1]);
                totalOfferedAmount = totalOfferedAmount + Integer.parseInt(values[2]);
            }

            records++;
        }

        scanner.close();


        double averageRate = rates / records;
        double[] availability = {averageRate, totalOfferedAmount};


        return availability;

    }
}
