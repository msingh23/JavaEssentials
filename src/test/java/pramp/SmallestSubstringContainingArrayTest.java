package pramp;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SmallestSubstringContainingArrayTest {

	public SmallestSubstringContainingArray handler;
	String inp[];
	Character[][] arr;
	String out[];

	@Before
	public void setUp() throws Exception {

		handler = new SmallestSubstringContainingArray();
		inp = new String[] { "xyyzyzyx", "cabeca", "ADOBECODEBANC" };
		arr = new Character[][] { { 'x', 'y', 'z' }, { 'c', 'a', 'e' }, { 'A', 'B', 'C' } };
		out = new String[] { "zyx", "eca", "BANC" };

	}

	@Test
	public void test() {

		for (int i = 0; i < inp.length; i++) {
			Assert.assertEquals(out[i], handler.getSmallestSubString(inp[i], arr[i]));
		}

	}

}
