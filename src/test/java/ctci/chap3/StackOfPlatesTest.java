package ctci.chap3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class StackOfPlatesTest {

	public StackOfPlates handler;

	@Before
	public void setUp() throws Exception {
		handler = new StackOfPlates(2);
		handler.push(1);
		handler.push(2);
		handler.push(3);
		handler.push(4);
		handler.push(5);
		handler.push(6);
		handler.push(7);
	}

	@Test
	public void test() throws Exception {
		Assert.assertEquals(handler.peek(), 7);
		Assert.assertEquals(handler.pop(), 7);
		Assert.assertEquals(handler.peek(), 6);
		Assert.assertEquals(handler.pop(), 6);
		Assert.assertEquals(handler.peek(), 5);
		Assert.assertEquals(handler.pop(), 5);
		Assert.assertEquals(handler.peek(), 4);
		Assert.assertEquals(handler.pop(), 4);

	}

	@Test
	public void testAtIndex() throws Exception {
		Assert.assertEquals(handler.peek(), 7);
		Assert.assertEquals(handler.popAt(1), 4);
		Assert.assertEquals(handler.popAt(0), 2);
		handler.push(8);
		handler.push(9);
		handler.push(10);
		Assert.assertEquals(handler.peek(), 10);
		Assert.assertEquals(handler.popAt(3), 10);
		Assert.assertEquals(handler.popAt(2), 8);
	}	

}
