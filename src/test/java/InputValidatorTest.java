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
        String amount = "2500";

        //WHEN
        boolean result = inputValidator.validateRequestedAmount(amount);

        //THEN
        assertEquals(true, result);
    }

    @Test
    public void testNonIncrementOf100Fails() {
        //GIVEN
        String amount = "11457";

        //WHEN
        boolean result = inputValidator.validateRequestedAmount(amount);

        //THEN
        assertEquals(false, result);
    }

    @Test
    public void testLowerLoanAmountIncrementOf100isRequested() {
        //GIVEN
        String amount = "1000";

        //WHEN
        boolean result = inputValidator.validateRequestedAmount(amount);

        //THEN
        assertEquals(true, result);
    }


    @Test
    public void testHigherLoanAmountOf15000IsRequested() {
        //GIVEN
        String amount = "15000";

        //WHEN
        boolean result = inputValidator.validateRequestedAmount(amount);

        //THEN
        assertEquals(true, result);
    }


}