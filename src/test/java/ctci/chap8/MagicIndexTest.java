package ctci.chap8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MagicIndexTest {

	public MagicIndex handler;
	int [] inp;
	int [] inp2;
	int index ;
	
	@Before
	public void setUp() throws Exception {
		handler = new MagicIndex();
		inp = new int[] {-1,0,1,2,3,5};
		inp2 = new int[] {1,3,4,5,6,7,7,7,7};
		index = 5;
		
	}

	@Test
	public void test() {
		Assert.assertEquals(5, handler.getIndex(inp));
		Assert.assertEquals(7, handler.getIndexNonUnique(inp2));
	}

}
