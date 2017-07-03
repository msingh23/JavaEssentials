package pramp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class IslandCountTest {

	public IslandCount handler;
	int inp[][];

	@Before
	public void setUp() throws Exception {
		handler = new IslandCount();
		inp = new int [][]{  {0,    1,    0,    1,    0},
	                         {0,    0,    1,    1,    1},
	                         {1,    0,    0,    1,    0},
	                         {0,    1,    1,    0,    0},
	                         {1,    0,    1,    0,    1} };
	}

	@Test
	public void test() {
		Assert.assertEquals(6, handler.getIslandCount(inp));
	}

}
