package range;

import java.util.List;

public class CSVExporter {

	public static void printRange(List<Range> rangeList) {
		if (!rangeList.isEmpty()) {
			System.out.println("Range,	Readings");
			for (Range range : rangeList) {
				System.out.println(formatPrintString(range));
			}
		}
	}

	public static String formatPrintString(Range range) {
		StringBuilder sb = new StringBuilder();
		sb.append(range.getMinimumValue()).append("-").append(range.getMaximumValue()).append(",	")
				.append(range.getCount());
		return sb.toString();
	}
}
