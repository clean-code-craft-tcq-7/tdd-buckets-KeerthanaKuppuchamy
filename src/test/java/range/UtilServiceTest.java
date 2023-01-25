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
	}
}
