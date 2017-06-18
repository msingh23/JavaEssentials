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

}
