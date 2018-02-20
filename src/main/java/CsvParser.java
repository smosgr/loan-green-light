import java.io.InputStream;
import java.util.Scanner;

public class CsvParser {

    public CsvParser(){}


    public static void parseDatafile(InputStream inputStream) {

        Scanner scanner = new Scanner(inputStream);
        scanner.useDelimiter(",");

        while (scanner.hasNext()) {
            System.out.print(scanner.next() + "|");
        }

        scanner.close();
    }
}
