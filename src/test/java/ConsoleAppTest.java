import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ConsoleAppTest {
    Scanner scanner;
    InputValidator inputValidator;
    String input = "";

    @Before
    public void initTestClass() {
        scanner = new Scanner(System.in);
        inputValidator = new InputValidator();
    }

    @Test
    public void testInputGivesExpectedOutput() {

        //GIVEN a string is provided as input
        String data = "quote.exe";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        //WHEN readConsole() is called
        ConsoleApp consoleApp = new ConsoleApp();
        String output = consoleApp.readFromConsole();

        //THEN the output is the same as the input
        assertEquals("quote.exe", output);
    }


    @Test
    public void testQuoteAppIsRunningWithSuccess() {
        //GIVEN
        input = "quote.exe";

        //WHEN
        boolean result = inputValidator.validateAppName(input);

        //THEN
        assertEquals(true, result);

    }

    @Test
    public void testAppWillExitWithSuccess() {
        //GIVEN
        input = "Q";

        //WHEN
        boolean result = inputValidator.validateAppName(input);

        //THEN
        assertEquals(false, result);
    }

    @Test
    public void testAppWillExitWithSuccess2() {
        //GIVEN
        input = "q";

        //WHEN
        boolean result = inputValidator.validateAppName(input);

        //THEN
        assertEquals(false, result);
    }

}