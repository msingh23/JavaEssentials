package ctci.chap8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class XpowerNTest {
	
	public XpowerN handler;
	

	@Before
	public void setUp() throws Exception {
		handler = new XpowerN();
		
	}

	@Test
	public void test() {
		Assert.assertEquals(1, handler.power(7, 0));
		Assert.assertEquals(7, handler.power(7, 1));
		Assert.assertEquals(8, handler.power(2,3));
		Assert.assertEquals(16, handler.power(2,4));
		Assert.assertEquals(32, handler.power(2,5));
	}

}
