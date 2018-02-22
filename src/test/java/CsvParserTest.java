import org.junit.Test;
import org.mockito.Mockito;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;


public class CsvParserTest {

    CsvParser csvParser = new CsvParser();
    InputStream inputStream = Mockito.mock(InputStream.class);

    @Test
    public void parsingMethodWillReturnTableOfTwoValues() {

        //WHEN
        double[] result = csvParser.parseDatafile(inputStream);

        //THEN
        assertEquals(2, result.length);
    }


}