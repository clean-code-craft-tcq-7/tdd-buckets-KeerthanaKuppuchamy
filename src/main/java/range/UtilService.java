package range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UtilService {

	public static void sortCollection(List<Integer> readings) {
		Collections.sort(readings);
	}

	public static List<Integer> convertStringToList(String values) {
		String[] arrayValue = values.split("\\s*,\\s*");
		List<Integer> readings = new ArrayList<Integer>();
		for (String value : arrayValue) {
			readings.add(Integer.valueOf(value));
		}
		return readings;
	}

	public static Range createRange(int minValue, int maxValue, int count) {
		Range range = new Range();
		range.setCount(count);
		range.setMaximumValue(maxValue);
		range.setMinimumValue(minValue);
		return range;
	}

	public static List<Integer> getAbsoluteValue(List<Integer> values) {
		List<Integer> absoluteValue = new ArrayList<Integer>();
		for (Integer value : values) {
			absoluteValue.add(Math.abs(value));
		}
		return absoluteValue;
	}
}
