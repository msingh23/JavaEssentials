/**
 * 
 */
package ctci.chap3;

/**
 * @author manu
 *
 */
public class MultiStack<T> {

	public class StackInfo {
		int start;
		int end;
		int capacity;

		public StackInfo(int start, int capacity) {
			this.start = start;
			this.capacity = capacity;
			end = start - 1;
		}

	}

	T value[];
	StackInfo[] stack;

	public MultiStack(int stackNo, int stackSize) {
		// TODO Auto-generated constructor stub
		stack = (MultiStack<T>.StackInfo[]) new Object[stackNo];

		for (int i = 0; i < stackNo; i++) {
			stack[i] = new StackInfo(i * stackNo, stackSize);
		}
		value = (T[]) new Object[stackNo * stackSize];
	}

	public void push(int stackNo, T data) throws Exception {

		if (isMultiTaskFull()) {
			throw new Exception("Stack is full");
		}

		if (stack[stackNo].end == stack[stackNo].capacity - 1) {
			expand(stackNo);
		}
		value[stack[stackNo].end + 1] = data;
		stack[stackNo].end = (stack[stackNo].end + 1) % value.length;

	}

	public T pop(int stackNo) throws Exception {
		T out;
		if ((stack[stackNo].end - 1 + value.length) % value.length < stack[stackNo].start) {
			throw new Exception("Empty Stack");
		}
		out = value[stack[stackNo].end];
		stack[stackNo].end = (stack[stackNo].end - 1 + value.length) % value.length;
		return out;
	}

	public T peek(int stackNo) throws Exception {
		T out;
		out = value[stack[stackNo].end];
		return out;
	}

	private void expand(int stackNo) {

		int next = (stackNo + 1) % stack.length;
		if (stack[next].end == stack[next].start + stack[next].capacity - 1) {
			expand(next);
			stack[next].capacity++;
		}
		int index = stack[next].start + stack[next].capacity - 1;
		while (index >= stack[next].start && index < (stack[next].start + stack[next].capacity) % value.length) {
			int prev = (index - 1 + value.length) % value.length;
			stack[prev] = stack[index];
			index = prev;
		}
		stack[next].capacity--;
		stack[next].start = (stack[next].start + 1) % value.length;

	}

	private boolean isMultiTaskFull() {
		int count = 0;
		for (StackInfo st : stack) {
			count += st.end;
		}
		return count == value.length;
	}

}
