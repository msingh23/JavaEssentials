package ctci.chap3;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MyQueueTest {

	private MyQueue<Character> handler;

	@Before
	public void setUp() throws Exception {
		handler = new MyQueue<Character>();
		handler.enqueue('h');
		handler.enqueue('e');
		handler.enqueue('l');
		handler.enqueue('l');
		handler.enqueue('o');
	}

	@Test
	public void test() throws Exception {
		Assert.assertEquals((char) handler.peek(), 'h');
		Assert.assertEquals((char) handler.dequeue(), 'h');
		Assert.assertEquals((char) handler.peek(), 'e');
		Assert.assertEquals(handler.isEmpty(), false);
		Assert.assertEquals((char) handler.dequeue(), 'e');
		Assert.assertEquals((char) handler.dequeue(), 'l');
		Assert.assertEquals((char) handler.dequeue(), 'l');
		Assert.assertEquals((char) handler.dequeue(), 'o');
		Assert.assertEquals(handler.isEmpty(), true);
		handler.enqueue('h');
		Assert.assertEquals((char) handler.peek(), 'h');
		Assert.assertEquals((char) handler.dequeue(), 'h');
		Assert.assertEquals(handler.isEmpty(), true);
	}

}
