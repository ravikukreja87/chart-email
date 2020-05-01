package chart.email;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static List<String> readCSV(String csvFile) {

		// String csvFile = "resources/ind_nifty100list.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<String> allCodes = new ArrayList<String>();
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] country = line.split(cvsSplitBy);

//				System.out.println("code = " + country[2]);
				allCodes.add(country[2]);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return allCodes;
	}
}