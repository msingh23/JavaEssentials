package ctci.chap3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class StackMinTest {

	public StackMin handler;

	@Before
	public void setUp() throws Exception {
		handler = new StackMin(10);
		handler.push(9);
		handler.push(-1);
		handler.push(11);
		handler.push(8);
		handler.push(1);
		handler.push(13);
		handler.push(2);
	}

	@Test
	public void test() {
		Assert.assertEquals(handler.peek(), 2);
	}

}
