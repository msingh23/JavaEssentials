package ctci.chap2;

import org.junit.Before;
import org.junit.Test;

public class SumListTest {

	public SumList handler;
	public LinkList<Integer> d1;
	public LinkList<Integer> d2;
	public LinkList<Integer> sum;
	public LinkList<Integer> sumRev;

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
		sumRev = new LinkList<Integer>(1);
		sumRev.addNode(3);
		sumRev.addNode(0);
		sumRev.addNode(8);
	}

	@Test
	public void test() {

		NodeTestUtils.assertNode(handler.sumList(d1.head, d2.head), sum.head);

	}

	@Test
	public void test2() {

		NodeTestUtils.assertNode(handler.sumRec(d1.head, d2.head, 0), sum.head);

	}

	@Test
	public void test3() {

		NodeTestUtils.assertNode(handler.sumRecWithUnitsAtEnd(d1.head, d2.head), sumRev.head);

	}

}
