/**
 * 
 */
package ctci.chap2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author manu
 *
 */
public class RemoveDuplicates {

	public static void removeDuplicates(LinkList list) {

		if (list != null) {

			Node curr = list.head;
			Set<Integer> set = new HashSet<Integer>();
			Node prev = null;

			while (curr != null) {
				if (set.contains(curr.data)) {
					prev.next = curr.next;

				} else {
					set.add((Integer) curr.data);
					prev = curr;

				}
				curr = curr.next;
			}

		}

	}

	public static void removeDuplicates2(LinkList list) {
		if (list != null) {
			Node curr = list.head;
			while (curr.next != null) {
				Node runner = curr.next;
				Node runnerPrev = curr;
				while (runner != null) {
					if (runner.data == curr.data) {
						runnerPrev.next = runner.next;
					} else {
						runnerPrev = runner;
					}

					runner = runner.next;

				}
				curr = curr.next;
			}

		}
	}

}
