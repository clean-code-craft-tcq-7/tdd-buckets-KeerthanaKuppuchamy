package range;

import java.util.ArrayList;
import java.util.List;

public class RangeCreater {

	public static void getRangeReading(String values) {
		List<Integer> readings = UtilService.convertStringToList(values);
		UtilService.sortCollection(readings);
		List<Range> rangeList = generateMapForReadingAndRange(readings);
		CSVExporter.printRange(rangeList);
	}

	public static List<Range> generateMapForReadingAndRange(List<Integer> readings) {
		List<Range> rangeList = new ArrayList<Range>();
		Range range = new Range();
		if (!readings.isEmpty()) {
			int count = 1;
			range.setMinimumValue(readings.get(0));
			for (Integer i = 1; i < readings.size(); i++) {
				if (readings.get(i).equals(readings.get(i - 1) + 1) || readings.get(i).equals(readings.get(i - 1))) {
					count++;
				} else {
					range.setMaximumValue(readings.get(i - 1));
					range.setCount(count);
					rangeList.add(range);
					count = 1;
					range = new Range();
					range.setMinimumValue(readings.get(i));
				}
			}
			range.setMaximumValue(readings.get(readings.size() - 1));
			range.setCount(count);
			rangeList.add(range);
		}
		return rangeList;
	}
}
