package range;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RangeCreaterTest {

	@Test
	public void testRangeCreater() {
		List<Integer> values = new ArrayList<Integer>(Arrays.asList(4, 5));
		List<Range> rangeList = RangeCreater.generateMapForReadingAndRange(values);
		assertTrue(!rangeList.isEmpty());
		assertEquals(new Integer(2), rangeList.get(0).getCount());
		assertEquals(new Integer(4), rangeList.get(0).getMinimumValue());
		assertEquals(new Integer(5), rangeList.get(0).getMaximumValue());

		values = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5, 6));
		rangeList = RangeCreater.generateMapForReadingAndRange(values);
		assertTrue(!rangeList.isEmpty());
		assertEquals(new Integer(3), rangeList.get(1).getCount());
		assertEquals(new Integer(1), rangeList.get(0).getMinimumValue());
		assertEquals(new Integer(2), rangeList.get(0).getMaximumValue());

		values = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 2));
		rangeList = RangeCreater.generateMapForReadingAndRange(values);
		assertTrue(!rangeList.isEmpty());
		assertEquals(new Integer(5), rangeList.get(0).getCount());
		assertEquals(new Integer(1), rangeList.get(0).getMinimumValue());
		assertEquals(new Integer(2), rangeList.get(0).getMaximumValue());

		// Negative values
		values = new ArrayList<Integer>(Arrays.asList(-1, -1, -1, 2, 2));
		rangeList = RangeCreater.generateMapForReadingAndRange(values);
		assertTrue(!rangeList.isEmpty());
		assertEquals(new Integer(3), rangeList.get(0).getCount());
		assertEquals(new Integer(-1), rangeList.get(0).getMinimumValue());
		assertEquals(new Integer(-1), rangeList.get(0).getMaximumValue());

		values = new ArrayList<Integer>();
		rangeList = RangeCreater.generateMapForReadingAndRange(values);
		assertTrue(rangeList.isEmpty());
	}
}
