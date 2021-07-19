
package uk.sky.extractor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.sky.Exception.FileFormatException;

import java.io.FileReader;
import java.io.Reader;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DriverDataExtractorTest {

    DriverDataExtractor driverExtractor;
    Reader reader;

    @BeforeEach
    public void setup() {
        driverExtractor = new DriverDataExtractor();
    }

    @Test
    public void should_extractDataByDriver() throws Exception {
        reader = new FileReader("src/test/resources/validDataFile.csv");


        Map<String, List<Double>> expected = new HashMap<>();
        List<Double> durationList = new ArrayList<>();
        durationList.add(4.32);
        durationList.add(4.88);
        durationList.add(4.38);
        expected.put("Alonzo", durationList);
        List<Double> durationList2 = new ArrayList<>();
        durationList2.add(4.75);
        durationList2.add(4.55);
        durationList2.add(4.59);
        expected.put("Verstrappen", durationList2);

        Map<String, List<Double>> result = driverExtractor.extractDataFromCSV(reader);


        assertEquals(expected, result);
    }

    @Test
    public void should_give_an_empty_list_in_case_file_is_empty() throws Exception {
        reader = new FileReader("src/test/resources/empty-file");
        Map<String, List<Double>> result = driverExtractor.extractDataFromCSV(reader);
        assertEquals(0, result.size());
        assertEquals(true, result.isEmpty());
    }

    @Test
    public void should_give_an_error_in_case_file_format_is_not_correct() throws Exception {
        reader = new FileReader("src/test/resources/broken-file");
        Exception e = assertThrows(FileFormatException.class, () -> {
            Map<String, List<Double>> result = driverExtractor.extractDataFromCSV(reader);
        });
        assertEquals("Source file format is incorrect, check the file", e.getMessage());
    }
}
