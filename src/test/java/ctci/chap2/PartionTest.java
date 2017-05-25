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
public class PartionTest {

	/**
	 * @throws java.lang.Exception
	 */

	public Partition<Integer> handler;
	public LinkList<Integer> in;
	public LinkList<Integer> out;

	@Before
	public void setUp() throws Exception {
		handler = new Partition<Integer>();
		in = new LinkList<Integer>(3);
		in.addNode(5);
		in.addNode(8);
		in.addNode(5);
		in.addNode(10);
		in.addNode(2);
		in.addNode(1);

		out = new LinkList<Integer>(10);
		out.addNode(10);
		out.addNode(10);
		out.addNode(10);
		out.addNode(10);
	}

	@Test
	public void test() {
		NodeTestUtils.printFromNode(in.head);
		handler.partition(in, 2);
		NodeTestUtils.printFromNode(in.head);
	}

	@Test
	public void test2() {
		NodeTestUtils.printFromNode(in.head);
		in.head = handler.partition2(in, 2);
		NodeTestUtils.printFromNode(in.head);
	}

}
