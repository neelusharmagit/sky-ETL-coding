package uk.sky;

import uk.sky.Load.DriverDataLoader;
import uk.sky.Transform.DriverDataTransformer;
import uk.sky.extractor.DriverDataExtractor;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Application {

	public static void main(String[] args) {

		try {

			System.out.println("**** Process Initiated ***** ");

			//load properties
			Properties defaultProps = new Properties();
			FileInputStream in = new FileInputStream("src/main/resources/application.properties");
			defaultProps.load(in);
			in.close();

			//Extract
			Reader reader = new FileReader(defaultProps.getProperty("filePath"));
			DriverDataExtractor dt = new DriverDataExtractor();
			Map<String,List<Double>> listDriverData = dt.extractDataFromCSV(reader);


			System.out.println("**** Data  Extracted ***** ");
			//Transform
			DriverDataTransformer transformer = new DriverDataTransformer();
			Map<String,Double> drivareData = transformer.transformData(listDriverData);

			System.out.println("**** Data  Transformed ***** ");
			//Load
			DriverDataLoader dataLoader = new DriverDataLoader();
			dataLoader.csvWriter(drivareData,defaultProps.getProperty("outputfilePath"));

			System.out.println("**** Data  Loaded  ***** ");
			System.out.println("**** Process Finishes Successfully ***** ");

		}catch (FileNotFoundException fe){
			System.out.println(" Problem encountered during execution : " +fe.getMessage());
		} catch (IOException ie) {
			System.out.println(" Problem encountered during execution : " +ie.getMessage());
		}
	}
}
