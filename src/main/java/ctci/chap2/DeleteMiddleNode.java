/**
 * 
 */
package ctci.chap2;

/**
 * @author manu
 *
 */
public class DeleteMiddleNode {

	public void deleteMiddleNode(Node n) {

		if (n == null || n.next == null) {
			return;
		}

		n.data = n.next.data;
		n.next = n.next.next;

	}

}
