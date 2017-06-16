package ctci.chap3;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class QueueTest {

	private Queue handler;

	@Before
	public void setUp() throws Exception {
		handler = new Queue<Character>();
		handler.enqueue('h');
		handler.enqueue('e');
		handler.enqueue('l');
		handler.enqueue('l');
		handler.enqueue('o');
	}

	@Test
	public void test() throws Exception {
		Assert.assertEquals(handler.peek(), 'h');
		Assert.assertEquals(handler.dequeue(), 'h');
		Assert.assertEquals(handler.peek(), 'e');
		Assert.assertEquals(handler.isEmpty(), false);
		Assert.assertEquals(handler.dequeue(), 'e');
		Assert.assertEquals(handler.dequeue(), 'l');
		Assert.assertEquals(handler.dequeue(), 'l');
		Assert.assertEquals(handler.dequeue(), 'o');
		Assert.assertEquals(handler.isEmpty(), true);
		handler.enqueue('h');
		Assert.assertEquals(handler.peek(), 'h');
		Assert.assertEquals(handler.dequeue(), 'h');
		Assert.assertEquals(handler.isEmpty(), true);
	}

}
