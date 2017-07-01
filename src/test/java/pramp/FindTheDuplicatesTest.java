package pramp;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindTheDuplicatesTest {

	public FindTheDuplicates handler;
	int[] inp1;
	int[] inp2;
	int[] out;

	@Before
	public void setUp() throws Exception {
		handler = new FindTheDuplicates();
		inp1 = new int[] { 1, 2, 3, 5, 6, 7 };
		inp2 = new int[] { 3, 6, 7, 8, 20 };
		out = new int[] { 3, 6, 7 };
	}

	@Test
	public void test() {
		Assert.assertArrayEquals(handler.getDuplicatesMequalsN(inp1, inp2), out);
		Assert.assertArrayEquals(handler.getDuplicatesMGreaterN(inp1, inp2), out);
	}

}
