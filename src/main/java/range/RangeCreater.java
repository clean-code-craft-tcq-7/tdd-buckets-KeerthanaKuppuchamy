package range;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeCreater {

	public static void getRangeReading(String values) throws IOException {
		List<Integer> readings = UtilService.convertStringToList(values);
		UtilService.sortCollection(readings);
		Map<String, Integer> map = generateMapForReadingAndRange(readings);
		CSVExporter.exportToCSV(map);
	}

	public static Map<String, Integer> generateMapForReadingAndRange(List<Integer> readings) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		if (!readings.isEmpty()) {
			int count = 1;
			StringBuilder sb = new StringBuilder();
			sb.append(readings.get(0)).append("-");
			for (Integer i = 1; i < readings.size(); i++) {
				if (readings.get(i).equals(readings.get(i - 1) + 1) || readings.get(i).equals(readings.get(i - 1))) {
					count++;
				} else {
					sb.append(readings.get(i - 1));
					map.put(sb.toString(), count);
					count = 1;
					sb = new StringBuilder();
					sb.append(readings.get(i)).append("-");
				}
			}
			sb.append(readings.get(readings.size() - 1));
			map.put(sb.toString(), count);
		}
		return map;
	}
}
