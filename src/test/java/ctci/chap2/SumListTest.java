package ctci.chap2;

import org.junit.Before;
import org.junit.Test;

public class SumListTest {

	public SumList handler;
	public LinkList<Integer> d1;
	public LinkList<Integer> d2;
	public LinkList<Integer> d3;
	public LinkList<Integer> d4;
	public LinkList<Integer> sum;
	public LinkList<Integer> sum2;
	public LinkList<Integer> sumRev;
	public LinkList<Integer> sumRev2;

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
		
		
		d3 = new LinkList<Integer>(7);
		d3.addNode(1);
		d3.addNode(6);
		d3.addNode(1);
		d4 = new LinkList<Integer>(5);
		d4.addNode(9);
		d4.addNode(2);
		sum2 = new LinkList<Integer>(2);
		sum2.addNode(1);
		sum2.addNode(9);
		sum2.addNode(1);
		sumRev2 = new LinkList<Integer>(7);
		sumRev2.addNode(7);
		sumRev2.addNode(5);
		sumRev2.addNode(3);
	}

	@Test
	public void test() {

		NodeTestUtils.assertNode(handler.sumList(d1.head, d2.head), sum.head);
		NodeTestUtils.assertNode(handler.sumList(d3.head, d4.head), sum2.head);

	}

	@Test
	public void test2() {

		NodeTestUtils.assertNode(handler.sumRec(d1.head, d2.head, 0), sum.head);
		NodeTestUtils.assertNode(handler.sumRec(d3.head, d4.head, 0), sum2.head);

	}

	@Test
	public void test3() {

		NodeTestUtils.assertNode(handler.sumRecWithUnitsAtEnd(d1.head, d2.head), sumRev.head);
		NodeTestUtils.assertNode(handler.sumRecWithUnitsAtEnd(d3.head, d4.head), sumRev2.head);

	}

}
