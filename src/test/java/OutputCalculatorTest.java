import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class OutputCalculatorTest {

    @Test
    public void testPrinterProvidesTheCorrectOutput() throws Exception {

        //GIVEN
        OutputCalculator outputCalculator = new OutputCalculator();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //WHEN
        outputCalculator.printOutput(400, 4, 4000, 1000);

        String expectedOutput = "Requested amount: £1000\n" +
                                "Rate: 4.0%\n" +
                                "Monthly repayment: £400.0\n" +
                                "Total repayment: £4000.0\n";
        //THEN
        assertEquals(expectedOutput, outContent.toString());
    }

}