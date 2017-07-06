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
public class RobotInGridTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	public RobotInGrid handler;
	int [][] grid;
	int [][] grid2;
	
	@Before
	public void setUp() throws Exception {
		handler = new RobotInGrid();
		grid = new int [][]{{0,0,0,0,0},
							{0,0,0,0,0},
							{0,0,0,0,0},
							{0,0,0,0,0},
							{0,0,0,0,0}};
	    grid2 = new int [][]{{0,0,0,0,0},
							{0,0,0,0,0},
							{0,0,0,0,0},
							{0,0,0,0,0},
							{0,0,0,0,1}};
	}

	@Test
	public void test() {
		Assert.assertEquals(true, handler.findPath(grid));
		Assert.assertEquals(false, handler.findPath(grid2));
		Assert.assertEquals(true, handler.findPathMemoization(grid));
		Assert.assertEquals(false, handler.findPathMemoization(grid2));
		
	}

}
