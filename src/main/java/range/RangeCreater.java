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
		if (!readings.isEmpty()) {
			int count = 1;
			int minValue = readings.get(0);
			int maxValue = 0;			
			for (Integer i = 1; i < readings.size(); i++) {
				if (readings.get(i).equals(readings.get(i - 1) + 1) || readings.get(i).equals(readings.get(i - 1))) {
					count++;
				} else {
					maxValue = readings.get(i - 1);
					rangeList.add(createRange(minValue, maxValue, count));
					count = 1;
					minValue = readings.get(i);
				}
			}
			maxValue = readings.get(readings.size() - 1);
			rangeList.add(createRange(minValue, maxValue, count));
		}
		return rangeList;
	}

	public static Range createRange(int minValue, int maxValue, int count) {
		Range range = new Range();
		range.setCount(count);
		range.setMaximumValue(maxValue);
		range.setMinimumValue(minValue);
		return range;
	}
}
