/**
 * 
 */
package ctci.chap2;

/**
 * @author manu
 *
 */
public class NodeUtils {

	public static void printFromNode(Node data) {
		Node temp = data;
		while (temp.next != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print(temp.data);
		System.out.println();
	}

}
