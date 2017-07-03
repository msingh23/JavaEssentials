package pramp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class RotatedArrayTest {

	public RotatedArray handler;
	int[][] inp;
	int[] out;
	int num;

	@Before
	public void setUp() throws Exception {
		handler = new RotatedArray();
		inp = new int[][] { { 9, 12, 17, 2, 4, 5 }, { 12, 17, 2, 4, 5, 9 }, { 17, 2, 4, 5, 9, 12 },
				{ 5, 9, 12, 17, 2, 4 }, { 4, 5, 9, 12, 17, 2 }, { 4, 5, 9, 12, 17, 2, 3 }, { 3, 4, 5, 9, 12, 17, 2 },
				{ 5, 9, 12, 17, 2, 3, 4 }, { 9, 12, 17, 2, 3, 4, 5 }, { 12, 17, 2, 3, 4, 5, 9 },
				{ 17, 2, 3, 4, 5, 9, 12 }, { 2, 3, 4, 5, 9, 12 } };

		num = 2;
		out = new int[] { 3, 2, 1, 4, 5, 5, 6, 4, 3, 2, 1, 0 };
	}

	@Test
	public void test() {
		for (int i = 0; i < inp.length; i++) {
			// System.out.println(i);
			Assert.assertEquals(out[i], handler.shiftedArrSearch(inp[i], num));
			Assert.assertEquals(out[i], handler.getIndexShifterArray(inp[i], num));

		}
	}

}
