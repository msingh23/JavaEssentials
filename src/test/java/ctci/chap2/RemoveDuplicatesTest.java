/**
 * 
 */
package ctci.chap2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author manu
 *
 */
public class RemoveDuplicatesTest {
	private LinkList linkList = null;
	private LinkList linkListOut = null;
	private RemoveDuplicates handler = null;
	// private Node head = null;

	@Before
	public void setup() {
		// head = new Node<Integer>(10);
		handler = new RemoveDuplicates();
		linkList = new LinkList<Integer>(5);
		linkList.addNode(6);
		linkList.addNode(7);
		linkList.addNode(6);
		linkList.addNode(11);
		linkList.addNode(5);
		linkList.addNode(5);

		linkListOut = new LinkList<Integer>(5);
		linkListOut.addNode(6);
		linkListOut.addNode(7);
		linkListOut.addNode(11);
	}

	@Test
	public void testRemoveDuplicate() {
		handler.removeDuplicates(linkList);
		NodeTestUtils.assertLinkList(linkList, linkListOut);

	}

	@Test
	public void testRemoveDuplicate2() {
		handler.removeDuplicates2(linkList);
		NodeTestUtils.assertLinkList(linkList, linkListOut);
	}

}
