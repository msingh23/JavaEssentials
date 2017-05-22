package ctci.chap2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {

	private LinkList<Integer> linkList;
	private Integer headVal;

	@Before
	public void setUp() throws Exception {
		headVal = 10;
		linkList = new LinkList<Integer>(headVal);

	}

	@Test
	public void testHead() {
		Assert.assertEquals(headVal, linkList.head.data);
	}

	@Test
	public void testAdd() {
		linkList.addNode(20);
		linkList.addNode(30);
		linkList.addNode(40);
		LinkList templinkList = new LinkList<Integer>(10);
		templinkList.head.next = new Node<Integer>(20);
		templinkList.head.next.next = new Node<Integer>(30);
		templinkList.head.next.next.next = new Node<Integer>(40);
		Node temp = linkList.head;
		Node temp2 = templinkList.head;
		while (temp.next != null && temp2.next != null) {
			Assert.assertEquals(temp.data, temp2.data);
			temp = temp.next;
			temp2 = temp2.next;
		}
		if (temp2.next != null || temp.next != null) {
			assert (false);
		}

	}

	@Test
	public void testRemove() {
		linkList.addNode(20);
		linkList.addNode(30);
		linkList.addNode(40);
		linkList.removeNode(30);
		LinkList templinkList = new LinkList<Integer>(10);
		templinkList.head.next = new Node<Integer>(20);
		templinkList.head.next.next = new Node<Integer>(40);

		Node temp = linkList.head;
		Node temp2 = templinkList.head;
		while (temp.next != null && temp2.next != null) {
			Assert.assertEquals(temp.data, temp2.data);
			temp = temp.next;
			temp2 = temp2.next;
		}
		if (temp2.next != null || temp.next != null) {
			assert (false);
		}

		linkList.removeNode(40);
		templinkList.removeNode(40);
		temp = linkList.head;
		temp2 = templinkList.head;
		while (temp.next != null && temp2.next != null) {
			Assert.assertEquals(temp.data, temp2.data);
			temp = temp.next;
			temp2 = temp2.next;
		}
		if (temp2.next != null || temp.next != null) {
			assert (false);
		}

		linkList.removeNode(20);
		linkList.removeNode(10);
		Assert.assertEquals(null, linkList.head);

	}

}
