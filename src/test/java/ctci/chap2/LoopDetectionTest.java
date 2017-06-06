package ctci.chap2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class LoopDetectionTest {

	private LinkList<Integer> in;
	private LinkList<Integer> in2;
	private Node<Integer> common;
	private LoopDetection<Integer> handler;

	@Before
	public void setUp() throws Exception {
		handler = new LoopDetection<Integer>();
		common = new Node<Integer>(10);
		in = new LinkList<Integer>(1);
		in.addNode(2);
		in.addNode(3);
		in.addNode(4);
		in.addNode(5);
		in.addNode(common);
		in.addNode(6);
		in.addNode(7);
		in.addNode(8);
		in.addNode(9);
		in.addNode(common);

		in2 = new LinkList<Integer>(1);
		in2.addNode(2);
		in2.addNode(3);
		in2.addNode(4);
		in2.addNode(5);
		in2.addNode(10);
		in2.addNode(6);
		in2.addNode(7);
		in2.addNode(8);
		in2.addNode(9);
	}

	@Test
	public void test() {
		Assert.assertEquals(handler.getLoopStartNode(in.head), common);
	}
	@Test
	public void test2() {
		Assert.assertEquals(handler.getLoopStartNode(in2.head), null);
	}

}
