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

}
