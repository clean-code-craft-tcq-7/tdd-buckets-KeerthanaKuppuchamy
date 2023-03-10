package range;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilServiceTest {

	@Test
	public void testSort() {
		List<Integer> inputList = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 6, 7));
		UtilService.sortCollection(inputList);
		assertEquals(new Integer(1), inputList.get(0));
	}

	@Test
	public void testStringToListConversion() {
		String input = "8,5,4";
		List<Integer> result = UtilService.convertStringToList(input);
		assertEquals(new Integer(8), result.get(0));

		// new line
		input = "8\n,5,4";
		result = UtilService.convertStringToList(input);
		assertEquals(new Integer(8), result.get(0));

		// negative value
		input = "8\n,-5,4";
		result = UtilService.convertStringToList(input);
		assertEquals(new Integer(8), result.get(0));
	}

	@Test
	public void testCreateRange() {
		Range range = UtilService.createRange(2, 5, 2);
		assertEquals(new Integer(2), range.getMinimumValue());
		assertEquals(new Integer(5), range.getMaximumValue());
		assertEquals(new Integer(2), range.getCount());
	}

	@Test
	public void testGetAbsoluteValue() {
		List<Integer> modifiedValues = UtilService.getAbsoluteValue(Arrays.asList(-15, 13, 0, -14));
		assertEquals(new Integer(15), modifiedValues.get(0));
	}
}
