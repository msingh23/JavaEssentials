package ctci.chap3;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MultiTaskTest {

	private MultiStack handler;

	@Before
	public void setUp() throws Exception {
		handler = new MultiStack(3, 2);
	}

	@Test
	public void test() throws Exception {
		handler.push(2, 1);
		handler.push(2, 2);
		handler.push(2, 3);
		handler.push(2, 4);
		handler.push(2, 5);
		handler.push(2, 6);
		Assert.assertEquals(handler.peek(2), 6);
		Assert.assertEquals(handler.pop(2), 6);
		handler.push(1, -1);
		Assert.assertEquals(handler.peek(1), -1);
		Assert.assertEquals(handler.pop(2), 5);
		handler.push(0, 10);
	}

}
