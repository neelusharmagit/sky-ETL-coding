
package uk.sky.load;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.sky.Exception.FileFormatException;
import uk.sky.Load.DriverDataLoader;
import uk.sky.extractor.DriverDataExtractor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DriverDataLoaderTest {

    DriverDataLoader driverDataLoader;
    FileWriter fileWriter;
    Reader reader;

    @BeforeEach
    public void setup() {
        driverDataLoader = new DriverDataLoader();
    }


    @Test
    public void should_write_correct_data() throws Exception {
        String path = "src/test/resources/newCreatedFile.csv";
        fileWriter = new FileWriter(path, false);
        Map<String,Double> fileContent = new HashMap<>();
        fileContent.put("Alonzo" , 4.526666666666666);
        fileContent.put("Verstrappen" , 4.63);
        fileContent.put("Hamilton" , 4.963333333333334);
        driverDataLoader.csvWriter(fileContent,path);

        reader = new FileReader("src/test/resources/newCreatedFile.csv");
        BufferedReader br = new BufferedReader(reader);
       System.out.println("****" + br.lines().count());

    }
}