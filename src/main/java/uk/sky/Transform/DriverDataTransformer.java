package uk.sky.Transform;

import java.util.*;
import java.util.stream.Collectors;


public class DriverDataTransformer {

    public Map<String,Double> transformData(Map<String,List<Double>> driverData) {

        Map<String,Double> sortedData = null;
        if (driverData != null) {
            Map<String, Double> driverDataMap = new HashMap<>();

            for (Map.Entry<String, List<Double>> entry : driverData.entrySet()) {
                OptionalDouble average = entry.getValue()
                        .stream()
                        .mapToDouble(a -> a)
                        .average();
                driverDataMap.put(entry.getKey(), average.getAsDouble());
            }
            sortedData = driverDataMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        }
        return  sortedData;
    }
}
