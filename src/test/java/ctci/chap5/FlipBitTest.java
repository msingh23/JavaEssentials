/**
 * 
 */
package ctci.chap5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author manu
 *
 */
public class FlipBitTest {

	/**
	 * @throws java.lang.Exception
	 */

	FlipBit handler;

	@Before
	public void setUp() throws Exception {
		handler = new FlipBit();
	}

	@Test
	public void test() {
		Assert.assertEquals(handler.getLongestSequence(1775), 8);
		Assert.assertEquals(5, handler.getLongestSequence(31));
		Assert.assertEquals(2, handler.getLongestSequence(32));
	}

}
