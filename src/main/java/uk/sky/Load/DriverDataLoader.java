package uk.sky.Load;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class DriverDataLoader {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";



    /**
     * @param listOfMap
     * @throws IOException
     */
    public void csvWriter(Map<String, Double> listOfMap,String path)  {

        FileWriter writer;
        try {
            int recordCounter = 0;
            writer = new FileWriter(path, false);
            for (Map.Entry<String,Double> data: listOfMap.entrySet()) {
                writer.append(data.getKey());
                writer.append(COMMA_DELIMITER);
                writer.append(String.valueOf(data.getValue()));
                writer.append(NEW_LINE_SEPARATOR);
                recordCounter++;
                if(recordCounter > 2){
                    break;
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
