/**
 * 
 */
package ctci.chap3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author manu
 *
 */
public class StackTest {

	/**
	 * @throws java.lang.Exception
	 */

	private Stack<Character> handler;

	@Before
	public void setUp() throws Exception {
		handler = new Stack<Character>();
		handler.push('h');
		handler.push('e');
		handler.push('l');
		handler.push('l');
		handler.push('o');
	}

	@Test
	public void test() throws Exception {
		Assert.assertEquals(handler.peek().charValue(), 'o');
		Assert.assertEquals(handler.pop().charValue(), 'o');
		Assert.assertEquals(handler.peek().charValue(), 'l');
		Assert.assertEquals(handler.isEmpty(), false);
		Assert.assertEquals(handler.pop().charValue(), 'l');
		Assert.assertEquals(handler.pop().charValue(), 'l');
		Assert.assertEquals(handler.pop().charValue(), 'e');
		Assert.assertEquals(handler.pop().charValue(), 'h');
		Assert.assertEquals(handler.isEmpty(), true);
		
	}

}
