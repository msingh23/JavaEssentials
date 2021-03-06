package ctci.chap8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class RecursiveMultiplyTest {

	public RecursiveMultiply handler;
	int a ;
	int b ;
	@Before
	public void setUp() throws Exception {
		handler = new RecursiveMultiply();
		a = 12;
		b = 19;
	}

	@Test
	public void test() {
		Assert.assertEquals(228, handler.multiply(a, b));
		Assert.assertEquals(228, handler.multiplyMemoization(a, b));
		Assert.assertEquals(228, handler.multiplyEfficient(a, b));
	}

}
