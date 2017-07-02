/**
 * 
 */
package pramp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author manu
 *
 */
public class BracketMatchTest {

	/**
	 * @throws java.lang.Exception
	 */
	public BracketMatch handler;
	public String text;

	@Before
	public void setUp() throws Exception {
		handler = new BracketMatch();
		text = new String("(())))()()))");

	}

	@Test
	public void test() {
		Assert.assertEquals(4, handler.bracketMatch(text));
		Assert.assertEquals(4, handler.bracketMatchStack(text));
	}

}
