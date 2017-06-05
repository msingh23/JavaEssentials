/**
 * 
 */
package ctci.chap2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author manu
 *
 */
public class IntersectionTest {

	private Intersection<Integer> handler;
	private LinkList<Integer> l1;
	private LinkList<Integer> l2;
	private LinkList<Integer> l3;
	private LinkList<Integer> l4;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		handler = new Intersection<Integer>();
		Node<Integer> common = new Node<Integer>(8);

		l1 = new LinkList<Integer>(1);
		l1.addNode(2);
		l1.addNode(3);
		l1.addNode(4);
		l3 = new LinkList<Integer>(1);
		l3.addNode(2);
		l3.addNode(3);
		l3.addNode(4);

		l2 = new LinkList<Integer>(1);
		l2.addNode(2);
		l2.addNode(3);
		l2.addNode(4);
		l4 = new LinkList<Integer>(1);
		l4.addNode(2);
		l4.addNode(3);
		l4.addNode(4);

		l1.addNode(common);
		l1.addNode(2);
		l1.addNode(3);
		l1.addNode(4);
		l2.addNode(common);
		l2.addNode(3);

	}

	@Test
	public void test() {
		assertEquals(true, handler.isIntersectionIterative(l1.head, l2.head));
	}

	@Test
	public void test2() {
		assertEquals(false, handler.isIntersectionIterative(l3.head, l4.head));
	}

}
