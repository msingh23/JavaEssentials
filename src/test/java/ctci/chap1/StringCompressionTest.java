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
public class StringCompressionTest {

	private String in[];
	private String out[];
	private StringCompression handler;

	@Before
	public void setup() {
		in = new String[] {"aabcccccaaa","abcd","aaabaaaaccaaaaba"};
		out = new String[] {"a2b1c5a3","abcd","a3b1a4c2a4b1a1"};
		handler = new StringCompression();

	}

	@Test
	public void test() {

		for (int i = 0; i < in.length; i++) {

			Assert.assertEquals(out[i], handler.Compression(in[i]));

		}

	}
}
