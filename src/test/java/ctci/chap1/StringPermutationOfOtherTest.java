/**
 * 
 */
package ctci.chap1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ctci.chap1.StringPermutationOfOther;
import junit.framework.AssertionFailedError;

/**
 * @author manu
 *
 */
public class StringPermutationOfOtherTest {

	private String[] inp;
	private String[] inp2;
	private boolean[] out;
	private StringPermutationOfOther handle;

	@Before
	public void setup() {
		handle = new StringPermutationOfOther();
		inp = new String[] { "sadder", "creative", "viral", "ad", "asdasd", "asd", "as" };
		inp2 = new String[] { "dreads", "reactive", "liar", "bc", "asdasda", null, "as" };
		out = new boolean[] { true, true, false, false, false, false, true };

	}

	@Test
	public void TestStringPermuationOfAnother() {
		for (int i = 0; i < inp.length; i++) {
			Assert.assertEquals(handle.isPermutationOfOther(inp[i], inp2[i]), out[i]);
		}

	}

	@Test
	public void TestStringPermuationOfAnother2() {
		for (int i = 0; i < inp.length; i++) {
			Assert.assertEquals(handle.isPermutationOfOther2(inp[i], inp2[i]), out[i]);
		}

	}
}
