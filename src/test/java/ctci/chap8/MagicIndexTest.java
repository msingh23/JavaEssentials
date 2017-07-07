package ctci.chap8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MagicIndexTest {

	public MagicIndex handler;
	int [] inp;
	int index ;
	
	@Before
	public void setUp() throws Exception {
		handler = new MagicIndex();
		inp = new int[] {-1,0,1,2,3,5};
		index = 5;
		
	}

	@Test
	public void test() {
		Assert.assertEquals(5, handler.getIndex(inp));
	}

}
