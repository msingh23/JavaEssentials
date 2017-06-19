/**
 * 
 */
package ctci.chap3;

/**
 * @author manu
 *
 */
public class SortStack {

	public Stack temp;

	public SortStack() {
		temp = new Stack<Integer>();
	}

	public void sortN2(Stack<Integer> st) throws Exception {
		if (st != null) {
			int size = 0;
			while (!st.isEmpty()) {
				compare(st, temp);
				size++;
			}
			MoveBetweenStack(temp, st, size);

		}
	}

	private void compare(Stack st, Stack temp2) throws Exception {
		Integer data = (Integer) st.pop();

		int count = 0;
		if (temp.isEmpty() && !st.isEmpty()) {
			temp.push(data);
		} else {
			while (Integer.valueOf(String.valueOf(temp.peek())) < data) {
				st.push(temp.pop());
				count++;
			}
			temp.push(data);
			MoveBetweenStack(st, temp, count);
		}
	}

	private void MoveBetweenStack(Stack from, Stack to, int count) throws Exception {
		while (count > 0) {
			to.push(from.pop());
			count--;
		}

	}

	public Stack SortStackNLogN(Stack<Integer> st1) throws Exception {
		int length = StackUtils.getLength(st1);
		return divide(1, length, st1);

	}

	private Stack divide(int start, int end, Stack<Integer> st1) throws Exception {
		if (start < end) {
			int mid = start + (end - start) / 2;
			Stack<Integer> s1 = new Stack<Integer>();
			for (int i = start; i <= mid; i++) {
				s1.push(st1.pop());
			}
			Stack<Integer> s2 = new Stack<Integer>();
			s1 = divide(start, mid, s1);
			for (int i = mid + 1; i <= end; i++) {
				s2.push(st1.pop());
			}
			s2 = divide(mid + 1, end, s2);
			return merge(s1, s2);
		}
		return st1;
	}

	private Stack merge(Stack<Integer> s1, Stack<Integer> s2) throws Exception {
		// TODO Auto-generated method stub
		Stack<Integer> merge = new Stack<Integer>();
		while (!s1.isEmpty() && !s2.isEmpty()) {
			if (s1.peek() > s2.peek()) {
				merge.push(s1.pop());
			} else {
				merge.push(s2.pop());
			}
		}
		while (!s1.isEmpty()) {
			merge.push(s1.pop());
		}
		while (!s2.isEmpty()) {
			merge.push(s2.pop());
		}

		return StackUtils.revereStack(merge);
	}

	

}
