package ctci.chap2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeleteMiddleNodeTest {

	public DeleteMiddleNode handler;
	public LinkList<Integer> list;
	public LinkList<Integer> listOut1;
	public LinkList<Integer> listOut2;
	public LinkList<Integer> listOut3;

	@Before
	public void setUp() throws Exception {
		
		handler = new DeleteMiddleNode();
		
		list = new LinkList<Integer>(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		
		listOut1 = new LinkList<Integer>(10);
		listOut1.addNode(20);
		listOut1.addNode(30);
		listOut1.addNode(40);
		
		listOut2 = new LinkList<Integer>(10);
		listOut2.addNode(20);
		listOut2.addNode(40);
		
		listOut3 = new LinkList<Integer>(10);
		listOut3.addNode(30);
		listOut3.addNode(40);

	}

	@Test
	public void test() {
	    handler.deleteMiddleNode(list.head.next.next.next);
		NodeTestUtils.assertLinkList(list, listOut1);
	}
	
	@Test
	public void test2() {
	    handler.deleteMiddleNode(list.head.next.next);
		NodeTestUtils.assertLinkList(list, listOut2);
	}
	
	@Test
	public void test3() {
	    handler.deleteMiddleNode(list.head.next);
		NodeTestUtils.assertLinkList(list, listOut3);
	}
	
//	@Test
//	public void test4() {
//	    handler.deleteMiddleNode(list.head);
//		NodeTestUtils.assertLinkList(list, listOut1);
//	}

}
