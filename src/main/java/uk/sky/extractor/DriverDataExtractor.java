package uk.sky.extractor;

import uk.sky.Exception.FileFormatException;
import uk.sky.domain.DriverData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class DriverDataExtractor {

    public Map<String, List<Double>> extractDataFromCSV(Reader source) {

        BufferedReader br = new BufferedReader(source);
        List<DriverData> allDriverData;

        Map<String, List<Double>> driverCollection = new HashMap<>();
        try {
            //collect All Data
            allDriverData =
                    br.lines()
                            .map(line -> line.split(","))
                            .map(line -> new DriverData(line)).collect(Collectors.toList());

            for (DriverData driverLineData : allDriverData) {

                List<Double> duration = driverCollection.get(driverLineData.getName());
                if (duration == null) {
                    duration = new ArrayList<Double>();
                    driverCollection.put(driverLineData.getName(), duration);
                }
                duration.add(driverLineData.getDuration());
            }
        } catch (Exception ex) {

            throw new FileFormatException("Source file format is incorrect, check the file", ex);

        }
        return driverCollection;
    }
}
