/**
 * 
 */
package ctci.chap1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author manu
 *
 */
public class OneEditDistanceStringTest {

	private String in1[];
	private String in2[];
	private boolean out[];
	private OneEditDistanceString handler;

	@Before
	public void setup() {

		in1 = new String[] { "pale", "pales", "pale", "pale", "pll", "plaz" };
		in2 = new String[] { "ple", "pale", "bale", "bake", "pell", "pelaz" };
		out = new boolean[] { true, true, true, false, true, true };
		handler = new OneEditDistanceString();

	}

	@Test
	public void test() {

		for (int i = 0; i < in1.length; i++) {
			Assert.assertEquals(out[i], handler.isOneDistanceAwayStrings(in1[i], in2[i]));
			Assert.assertEquals(out[i], handler.isOneDistanceAwayStrings2(in1[i], in2[i]));
		}

	}

}
