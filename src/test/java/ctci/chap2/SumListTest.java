package ctci.chap2;

import org.junit.Before;
import org.junit.Test;

public class SumListTest {

	public SumList handler;
	public LinkList<Integer> d1;
	public LinkList<Integer> d2;
	public LinkList<Integer> sum;

	@Before
	public void setUp() throws Exception {

		handler = new SumList();
		d1 = new LinkList<Integer>(7);
		d1.addNode(1);
		d1.addNode(6);
		d2 = new LinkList<Integer>(5);
		d2.addNode(9);
		d2.addNode(2);
		sum = new LinkList<Integer>(2);
		sum.addNode(1);
		sum.addNode(9);
	}

	@Test
	public void test() {

		NodeTestUtils.assertNode(handler.sumList(d1.head, d2.head), sum.head);

	}

}
