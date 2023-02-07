package range;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CSVExporterTest {

	@Test
	public void testFormatPrintString() {
		Range range = createRangeList();
		String rangeReading = CSVExporter.formatPrintString(range);
		assertEquals("4-5,	2", rangeReading);

	}

	private Range createRangeList() {
		Range range = new Range();
		range.setCount(2);
		range.setMaximumValue(5);
		range.setMinimumValue(4);
		return range;
	}

}
