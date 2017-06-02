/**
 * 
 */
package ctci.chap2;

/**
 * @author manu
 *
 */
public class SumList {

	public Node sumList(Node n1, Node n2) {

		Node<Integer> sum = null;
		Node<Integer> p1 = n1;
		Node<Integer> p2 = n2;
		Node tail = null;

		if (null != n1 && null != n2) {
			int carry = 0;
			int out[] = null;
			while (p1 != null && p2 != null) {

				out = add(p1.data, p2.data, carry);
				carry = out[1];
				Node add = new Node<Integer>(out[0]);
				if (sum == null) {
					sum = add;
					tail = sum;
				} else {
					tail.next = add;
					tail = add;

				}
				p1 = p1.next;
				p2 = p2.next;
			}

			while (p1 != null) {
				out = add(p1.data, 0, carry);
				carry = out[1];
				Node add = new Node<Integer>(out[0]);
				if (sum == null) {
					sum = add;
					tail = sum;
				} else {
					tail.next = add;
					tail = add;

				}

				p1 = p1.next;
			}

			while (p2 != null) {
				out = add(0, p2.data, carry);
				carry = out[1];
				Node add = new Node<Integer>(out[0]);
				if (sum == null) {
					sum = add;
					tail = sum;
				} else {
					tail.next = add;
					tail = add;

				}

				p2 = p2.next;
			}
		}
		return sum;
	}

	private void updateSum(Node tail, Node<Integer> sum, int[] out) {

		if (null == sum) {
			sum = new Node<Integer>(out[0]);
			tail = sum;

		} else {
			Node dig = new Node<Integer>(out[0]);
			tail.next = dig;
			tail = dig;

		}

	}

	private int[] add(Integer data, Integer data2, int carry) {
		int[] out = new int[2];
		int sum = data + data2 + carry;
		out[0] = sum % 10;
		out[1] = sum / 10;
		return out;
	}

	public Node sumRec(Node<Integer> p1, Node<Integer> p2, int carry) {

		if (p1 == null && p2 == null) {
			return null;
		}
		carry += ((p1 == null) ? 0 : p1.data) + ((p2 == null ? 0 : p2.data));
		Node add = new Node<Integer>(carry % 10);
		Node join = sumRec(p1 == null ? null : p1.next, p2 == null ? null : p2.next, carry / 10);
		add.next = join;
		return add;

	}

	public class sum {
		Node sum;
		int carry;

		public sum() {
			carry = 0;
			sum = null;
		}
	}

	public Node sumRecWithUnitsAtEnd(Node<Integer> p1, Node<Integer> p2) {

		int len1 = length(p1);
		int len2 = length(p2);

		if (len1 < len2) {
			p1 = padZero(p1, len2 - len1);
		} else {
			p2 = padZero(p2, len1 - len2);
		}
		sum ans = SumListRever(p1, p2);
		return (ans.carry > 0) ? insertBefore(ans.sum, new Node<Integer>(ans.carry)) : ans.sum;

	}

	private sum SumListRever(Node<Integer> p1, Node<Integer> p2) {

		if (p1 == null || p2 == null) {
			return new sum();
		}

		sum prevSum = SumListRever(p1.next, p2.next);
		int digSum = p1.data + p2.data + prevSum.carry;
		Node currSum = new Node<Integer>(digSum % 10);
		currSum.next = prevSum.sum;
		sum isum = new sum();
		isum.sum = currSum;
		isum.carry = digSum / 10;
		return isum;

	}

	public int length(Node node) {
		Node temp = node;
		int len = 0;
		while (temp != null) {
			len++;
			temp = temp.next;
		}
		return len;
	}

	public Node padZero(Node node, int len) {

		for (int i = len; i > 0; i--) {
			node = insertBefore(node, new Node<Integer>(0));
		}
		return node;

	}

	private Node insertBefore(Node node, Node<Integer> node2) {
		node2.next = node;
		return node2;
	}
}
