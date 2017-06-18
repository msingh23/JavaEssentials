package ctci.chap3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class StackMin2Test {

	public StackMin2 handler;

	@Before
	public void setUp() throws Exception {
		handler = new StackMin2(9);
		handler.push(10);
		handler.push(-1);
		handler.push(11);
		handler.push(8);
		handler.push(1);
		handler.push(13);
		handler.push(2);
	}

	@Test
	public void test() throws Exception {
		Assert.assertEquals(handler.peek(), 2);
		Assert.assertEquals(handler.min(), -1);
		Assert.assertEquals(handler.pop(), 2);
		Assert.assertEquals(handler.min(), -1);
		Assert.assertEquals(handler.pop(), 13);
		Assert.assertEquals(handler.min(), -1);
		Assert.assertEquals(handler.pop(), 1);
		Assert.assertEquals(handler.min(), -1);
		Assert.assertEquals(handler.pop(), 8);
		Assert.assertEquals(handler.min(), -1);
		Assert.assertEquals(handler.pop(), 11);
		Assert.assertEquals(handler.min(), -1);
		Assert.assertEquals(handler.pop(), -1);
		Assert.assertEquals(handler.min(), 9);
		Assert.assertEquals(handler.pop(), 10);
		Assert.assertEquals(handler.min(), 9);
	}


}
