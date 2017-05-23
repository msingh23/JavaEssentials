package ctci.chap2;

import org.junit.Assert;

public class NodeTestUtils {
	public static void assertLinkList(LinkList list1, LinkList list2) {
		Node temp = list1.head;
		Node temp2 = list2.head;
		while (temp.next != null && temp2.next != null) {
			Assert.assertEquals(temp.data, temp2.data);
			temp = temp.next;
			temp2 = temp2.next;
		}
		if (temp2.next != null || temp.next != null) {
			assert (false);
		}
	}

}
