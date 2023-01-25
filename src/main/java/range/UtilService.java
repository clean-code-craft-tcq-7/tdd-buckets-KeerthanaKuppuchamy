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
}
