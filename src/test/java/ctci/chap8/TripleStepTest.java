/**
 * 
 */
package ctci.chap8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author manu
 *
 */
public class TripleStepTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	/*
	 *  if n = 3
	 *  [1,1,1], [1,2], [2,1], [3]
	 *  
	 *  if n=4
	 *  [1,1,1,1], [1,1,2], [1,2,1], [1,3], [3,1]
	 *  
	 *  if n = 5
	 *  [1,1,1,1,1], 
	 *  [1,1,1,2] 
	 *  [1,1,2,1]
	 *  [1,2,1,1]
	 *  [1,1,3]
	 *  [1,2,2]
	 *  [1,2,1,1]
	 *  [2,1,1,1]
	 *  [2,1,2]
	 *  [2,2,1]
	 *  [2,3]
	 *  [3,1,1]
	 *  [3,2]
	 * 
	 */
	
	public TripleStep handler;
	int steps [];
	int ways [];
	@Before
	public void setUp() throws Exception {
		handler = new TripleStep();
		steps  = new int []{3,4,5};
		ways = new int []{4,7,13};
		
	}

	@Test
	public void test() {
		for(int i = 0 ; i< steps.length ; i++)
		{
			Assert.assertEquals(handler.getStepWays(steps[i]), ways[i]);
		}
	}

}
