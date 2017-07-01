/**
 * 
 */
package pramp;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author manu
 *
 */
public class SentenceReverseTest {

	/**
	 * @throws java.lang.Exception
	 */

	SentenceReverse handler;
	char[] inp;
	char[] out;

	@Before
	public void setUp() throws Exception {
		handler = new SentenceReverse();
		inp = new char[] { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c',
				't', 'i', 'c', 'e' };
		out = new char[] { 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'e', 'r',
				'f', 'e', 'c', 't' };
	}

	@Test
	public void test() {
		//Assert.assertArrayEquals(out, handler.reverseWords(inp));
		Assert.assertArrayEquals(out, handler.SentenceReverse(inp));
	}

}
