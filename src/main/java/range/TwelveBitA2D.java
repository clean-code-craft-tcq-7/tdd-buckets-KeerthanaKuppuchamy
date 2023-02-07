package range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwelveBitA2D {

	public static final Integer smallestReportableNumber = 0;
	public static final Integer largestReportableNumber = 4094;
	public static final Integer largestReportedCurrent = 10;

	public static List<Integer> getTwelveBitConvertedReadings(List<Integer> readings) {
		List<Integer> convertedReadings = new ArrayList<Integer>();
		for (Integer reading : readings) {
			if (reading > largestReportableNumber || reading < smallestReportableNumber) {
				System.out.println("Invalid reading: " + reading);
			} else {
				convertedReadings.add(twelveBitA2DConvertor(reading));
			}
		}
		return convertedReadings;
	}

	private static Integer twelveBitA2DConvertor(Integer reading) {
		Float value = ((float) reading * largestReportedCurrent) / largestReportableNumber;
		return Math.round(value);
	}

}
