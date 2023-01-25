package range;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.opencsv.CSVWriter;

public class CSVExporter {

	public static void exportToCSV(Map<String, Integer> map) throws IOException {
		File file = new File("./range_readings.csv");
		CSVWriter writer = new CSVWriter(new FileWriter(file));
		writer.writeNext(new String[] { "Range", "Readings" });
		for (Map.Entry<String, Integer> loopMap : map.entrySet()) {
			writer.writeNext(new String[] { loopMap.getKey(), String.valueOf(loopMap.getValue()) });
		}
		writer.flush();
		writer.close();
	}
}
