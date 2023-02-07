package range;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TenBitA2D {

	public static final Integer smallestReportableNumber = 0;
	public static final Integer largestReportableNumber = 1023;
	public static final Integer largestReportedCurrent = 30;

	public static List<Integer> getTenBitConvertedReadings(List<Integer> readings) {
		Map<Integer, Integer> currentRange = generateMap();
		List<Integer> convertedReadings = new ArrayList<Integer>();
		for (Integer reading : readings) {
			if (reading > largestReportableNumber || reading < smallestReportableNumber) {
				System.out.println("Invalid reading: " + reading);
			} else {
				convertedReadings.add(tenBitA2DConvertor(currentRange, reading));
			}
		}
		return convertedReadings;
	}

	private static Integer tenBitA2DConvertor(Map<Integer, Integer> currentRange, Integer reading) {
		Float value = ((float) reading * largestReportedCurrent) / largestReportableNumber;
		if (currentRange.containsKey(Math.round(value))) {
			return currentRange.get(Math.round(value));
		}
		return 0;
	}

	private static Map<Integer, Integer> generateMap() {
		Integer current = -15;
		Map<Integer, Integer> currentRange = new HashMap<Integer, Integer>();
		for (int i = 0; i <= 30; i++) {
			currentRange.put(i, current);
			current++;
		}
		return currentRange;
	}
}
