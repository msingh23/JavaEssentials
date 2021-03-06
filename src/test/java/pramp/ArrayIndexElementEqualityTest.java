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
public class ArrayIndexElementEqualityTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	public ArrayIndexElementEquality handler;
	public int [] inp;
	public int [] inp2;
	public int [] inp3;
	@Before
	public void setUp() throws Exception {
		handler = new ArrayIndexElementEquality();
		inp = new int []{-8,0,2,5};
		inp2 = new int [] {-1,0,3,6};
		inp3 = new int [] {-2, -1, 1,2,3,4,6};
	}

	@Test
	public void test() {
		Assert.assertEquals(2, handler.getEqualityIndex(inp));
		Assert.assertEquals(-1, handler.getEqualityIndex(inp2));
		Assert.assertEquals(6, handler.getEqualityIndex(inp3));
	}

}
