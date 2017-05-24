package ctci.chap2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class KthElementFromEndTest {

	private KthElementFromTheLast handler;
	private LinkList list;

	@Before
	public void setUp() throws Exception {
		handler = new KthElementFromTheLast();
		list = new LinkList<Integer>(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.addNode(50);
		list.addNode(60);

	}

	@Test
	public void test() {
		Assert.assertEquals(10, handler.getKthFromLast(list, 6).data);
		Assert.assertEquals(60, handler.getKthFromLast(list, 1).data);
		Assert.assertEquals(40, handler.getKthFromLast(list, 3).data);

	}

	@Test
	public void test2() {
		Assert.assertEquals(10, handler.getKthNodeFromLast2(list, 6).data);
		Assert.assertEquals(60, handler.getKthNodeFromLast2(list, 1).data);
		Assert.assertEquals(40, handler.getKthNodeFromLast2(list, 3).data);

	}

}
