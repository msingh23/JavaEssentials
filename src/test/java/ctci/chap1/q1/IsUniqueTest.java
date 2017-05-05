/**
 * 
 */
package ctci.chap1.q1;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ctci.chap1.IsUnique;
import junit.framework.Assert;

/**
 * @author manu
 *
 */
public class IsUniqueTest {

	private String[] inp;
	private boolean[] out;
	private IsUnique isUnique;

	@Before
	public void setup() {
		inp = new String[] { "abcde", "cc", "c", "hello", "apple", "kite", "padle", "null",
				"!@#$%^&*()QWERTYP{}|ASDFGHJKL:ZXCVBNM<>?" };
		out = new boolean[] { true, false, true, false, false, true, true, false, true };

	}

	@Test
	public void testUniqueString() {
		for (int i = 0; i < inp.length; i++) {
			Assert.assertEquals(out[i], isUnique.isUnique(inp[i]));

		}
	}

}
