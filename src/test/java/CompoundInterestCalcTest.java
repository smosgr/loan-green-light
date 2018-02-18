import org.junit.Test;

public class CompoundInterestCalcTest {

    @Test
    public void testCompoundInterestCalculation(){

        double amount = 1500.0;

        for (int x = 0; x < 3; x++) {
            amount = amount * Math.pow(1.0 + 0.054444285714286, 3);
            System.out.println("------- THE AMOUNT IS --------" + amount);

        }


    }

}