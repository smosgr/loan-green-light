import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputValidatorTest {

    InputValidator inputValidator;

    @Before
    public void initTestClass() {
        inputValidator = new InputValidator();
    }

    @Test
    public void testIncrementsOf100AreRequestedSuccess() {
        //GIVEN
        int correctIncrement = 2500;

        //WHEN
        boolean result = inputValidator.validateRequestedAmount(correctIncrement);

        //THEN
        assertEquals(true, result);
    }

    @Test
    public void testNonIncrementOf100Fails() {
        //GIVEN
        int wrongIncrement = 11457;

        //WHEN
        boolean result = inputValidator.validateRequestedAmount(wrongIncrement);

        //THEN
        assertEquals(false, result);
    }

    @Test
    public void testLowerLoanAmountIncrementOf100isRequested() {
        //GIVEN
        int lowThreshold = 1000;

        //WHEN
        boolean result = inputValidator.validateRequestedAmount(lowThreshold);

        //THEN
        assertEquals(true, result);
    }


    @Test
    public void testHigherLoanAmountOf15000IsRequested() {
        //GIVEN
        int highThreshold = 15000;

        //WHEN
        boolean result = inputValidator.validateRequestedAmount(highThreshold);

        //THEN
        assertEquals(true, result);
    }


    @Test
    public void testMarketCsvFileIsFound() {
        //GIVEN
        String filename = "market.csv";

        //WHEN
        boolean result = inputValidator.validateDataFilename(filename);

        //THEN
        assertEquals(true, result);
    }

    @Test
    public void testFailureWhenWrongFileIsUsed() {
        //GIVEN
        String filename = "wrong-filename";

        //WHEN
        boolean result = inputValidator.validateDataFilename(filename);

        //THEN
        assertEquals(false, result);
    }


}