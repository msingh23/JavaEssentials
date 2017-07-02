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
public class BasicRegexParserTest {

	/**
	 * @throws java.lang.Exception
	 */
	public BasicRegexParser handler;
	String[] text;
	String[] pattern;
	Boolean[] out;

	@Before
	public void setUp() throws Exception {
		handler = new BasicRegexParser();
		text = new String[] { "aa", "aa", "abc", "abbb", "acd", "abbcd" };
		pattern = new String[] { "a", "aa", "a.c", "ab*", "ab*c.", "ab*bcd" };
		out = new Boolean[] { false, true, true, true, true, true };
	}

	@Test
	public void test() {
		for (int i = 0; i < text.length; i++) {
			Assert.assertEquals(out[i], handler.parse(text[i], pattern[i]));
		}
	}

}
