package ctci.chap4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class PriorityQueueTest {

	public PriorityQueue<Character> handler;
	public PriorityQueue<Character> handler2;

	@Before
	public void setUp() throws Exception {
		handler = new PriorityQueue<Character>(1, 0);
		handler2 = new PriorityQueue<Character>(1, 1);
		handler.insert(handler.new HeapNode<Character>('l', 3));
		handler.insert(handler.new HeapNode<Character>('l', 4));
		handler.insert(handler.new HeapNode<Character>('0', 5));
		handler.insert(handler.new HeapNode<Character>('w', 6));
		handler.insert(handler.new HeapNode<Character>('o', 7));
		handler.insert(handler.new HeapNode<Character>('r', 8));
		handler.insert(handler.new HeapNode<Character>('l', 9));
		handler.insert(handler.new HeapNode<Character>('d', 10));
		handler.insert(handler.new HeapNode<Character>('h', 1));
		handler.insert(handler.new HeapNode<Character>('e', 2));

		handler2.insert(handler2.new HeapNode<Character>('l', 3));
		handler2.insert(handler2.new HeapNode<Character>('l', 4));
		handler2.insert(handler2.new HeapNode<Character>('0', 5));
		handler2.insert(handler2.new HeapNode<Character>('w', 6));
		handler2.insert(handler2.new HeapNode<Character>('o', 7));
		handler2.insert(handler2.new HeapNode<Character>('r', 8));
		handler2.insert(handler2.new HeapNode<Character>('l', 9));
		handler2.insert(handler2.new HeapNode<Character>('d', 10));
		handler2.insert(handler2.new HeapNode<Character>('h', 1));
		handler2.insert(handler2.new HeapNode<Character>('e', 2));
	}

	@Test
	public void test() throws Exception {

		Assert.assertEquals('h', handler.extractTop().data);
		Assert.assertEquals('e', handler.extractTop().data);
		Assert.assertEquals('l', handler.extractTop().data);
		Assert.assertEquals('l', handler.extractTop().data);
		Assert.assertEquals('0', handler.extractTop().data);
		Assert.assertEquals('w', handler.extractTop().data);
		Assert.assertEquals('o', handler.extractTop().data);
		Assert.assertEquals('r', handler.extractTop().data);
		Assert.assertEquals('l', handler.extractTop().data);
		Assert.assertEquals('d', handler.extractTop().data);

		Assert.assertEquals('d', handler2.extractTop().data);
		Assert.assertEquals('l', handler2.extractTop().data);
		Assert.assertEquals('r', handler2.extractTop().data);
		Assert.assertEquals('o', handler2.extractTop().data);
		Assert.assertEquals('w', handler2.extractTop().data);
		Assert.assertEquals('0', handler2.extractTop().data);
		Assert.assertEquals('l', handler2.extractTop().data);
		Assert.assertEquals('l', handler2.extractTop().data);
		Assert.assertEquals('e', handler2.extractTop().data);
		Assert.assertEquals('h', handler2.extractTop().data);

	}

}
