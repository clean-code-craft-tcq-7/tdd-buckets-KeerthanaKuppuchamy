package range;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class RangeCreaterTest {

	@Test
	public void testRangeCreater() {
		List<Integer> values = new ArrayList<Integer>(Arrays.asList(4, 5));
		Map<String, Integer> map = RangeCreater.generateMapForReadingAndRange(values);
		assertTrue(map.containsKey("4-5"));
		assertEquals(new Integer(2), map.get("4-5"));

		values = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5, 6));
		map = RangeCreater.generateMapForReadingAndRange(values);
		assertTrue(map.containsKey("4-6"));
		assertTrue(map.containsKey("1-2"));
		assertEquals(new Integer(2), map.get("1-2"));
		assertEquals(new Integer(3), map.get("4-6"));

		values = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 2));
		map = RangeCreater.generateMapForReadingAndRange(values);
		assertTrue(map.containsKey("1-2"));
		assertEquals(new Integer(5), map.get("1-2"));

		values = new ArrayList<Integer>();
		map = RangeCreater.generateMapForReadingAndRange(values);
		assertTrue(map.isEmpty());

	}
}
