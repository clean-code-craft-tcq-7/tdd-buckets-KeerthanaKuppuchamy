package range;

import java.util.ArrayList;
import java.util.List;

public class RangeCreater {

	public static void getRangeReading(String values) {
		List<Integer> valueInList = UtilService.convertStringToList(values);

		List<Integer> readings = TwelveBitA2D.getTwelveBitConvertedReadings(valueInList);
		readings = UtilService.getAbsoluteValue(readings);
		UtilService.sortCollection(readings);
		List<Range> rangeList = generateMapForReadingAndRange(readings);
		CSVExporter.printRange(rangeList);

		readings = TenBitA2D.getTenBitConvertedReadings(valueInList);
		readings = UtilService.getAbsoluteValue(readings);
		UtilService.sortCollection(readings);
		rangeList = generateMapForReadingAndRange(readings);
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
					rangeList.add(UtilService.createRange(minValue, maxValue, count));
					count = 1;
					minValue = readings.get(i);
				}
			}
			maxValue = readings.get(readings.size() - 1);
			rangeList.add(UtilService.createRange(minValue, maxValue, count));
		}
		return rangeList;
	}
}
