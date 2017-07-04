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
public class PairwiseSwapTest {

	/**
	 * 	   128 64 32 16 8 4 2 1	
	 * 	 x = 0  1  0  1 0 0 1 0 = 82
	 * 	 o = 1  0  1  0 0 0 0 1 = 161
	 *   x1 = 				1 0 = 2
	 *   o1 =               0 1 = 1							
	 * @throws java.lang.Exception
	 */
	
	
	public PairwiseSwap handler;
	int x;
	int x1;
	int x2;
	@Before
	public void setUp() throws Exception {
		handler = new PairwiseSwap();
		x = 82;
		x1 = 2;
		x2 = 0;
	}

	@Test
	public void test() {
		Assert.assertEquals(161, handler.pairWiseSwap(x));
		Assert.assertEquals(1, handler.pairWiseSwap(x1));
		Assert.assertEquals(0, handler.pairWiseSwap(x2));
	}

}
