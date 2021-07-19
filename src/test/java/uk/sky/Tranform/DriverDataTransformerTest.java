package uk.sky.Tranform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.sky.Transform.DriverDataTransformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class DriverDataTransformerTest {


    DriverDataTransformer driverDataTransformer;
    Map<String, List<Double>> data;

    @BeforeEach
    public void setup() {
        driverDataTransformer = new DriverDataTransformer();
        data = new HashMap<>();
        List<Double> durationList = new ArrayList<>();
        durationList.add(4.32);
        durationList.add(4.88);
        durationList.add(4.38);
        data.put("Alonzo", durationList);
        List<Double> durationList2 = new ArrayList<>();
        durationList2.add(4.75);
        durationList2.add(4.55);
        durationList2.add(4.59);
        data.put("Verstrappen", durationList2);
        List<Double> durationList3 = new ArrayList<>();
        durationList3.add(5.75);
        durationList3.add(3.55);
        durationList3.add(5.59);
        data.put("Hamilton", durationList3);

    }


    @Test
    public void should_sortDataByDriverLaps() throws Exception {

        Map<String,Double> expectedData = new HashMap<>();
        expectedData.put("Alonzo" , 4.526666666666666);
        expectedData.put("Verstrappen" , 4.63);
        expectedData.put("Hamilton" , 4.963333333333334);
        Map<String,Double> sortedData = driverDataTransformer.transformData(data);
        assertEquals(expectedData, sortedData);

    }


    @Test
    public void should_checkEmptyData() throws Exception {
        Map<String,Double> sortedData = driverDataTransformer.transformData(new HashMap<>());
        assertTrue(sortedData.isEmpty());
    }


    @Test
    public void should_checkNullyData() throws Exception {
        Map<String,Double> sortedData = driverDataTransformer.transformData(null);
        assertNull(sortedData);
    }

}
