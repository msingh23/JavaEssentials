/**
 * 
 */
package ctci.chap3;

/**
 * @author manu
 *
 */
public class MultiStack {

	public class StackInfo {
		int start;
		int end;
		int capacity;
		int size;

		public StackInfo(int start, int capacity) {
			this.start = start;
			this.capacity = capacity;
			end = start - 1;
			size = 0;
		}

	}

	int value[];
	StackInfo[] stack;

	public MultiStack(int stackNo, int stackSize) {
		// TODO Auto-generated constructor stub
		stack = new StackInfo[stackNo];

		for (int i = 0; i < stackNo; i++) {
			stack[i] = new StackInfo(i * stackNo, stackSize);
		}
		value = new int[stackNo * stackSize];
	}

	public void push(int stackNo, int data) throws Exception {

		if (isMultiTaskFull()) {
			throw new Exception("Stack is full");
		}

		if (stack[stackNo].start + stack[stackNo].size == stack[stackNo].capacity) {
			expand(stackNo);
		}
		value[(stack[stackNo].size) % value.length] = data;
		// stack[stackNo].end = (stack[stackNo].end + 1) % value.length;
		stack[stackNo].size++;

	}

	public int pop(int stackNo) throws Exception {
		int out;
		if (stack[stackNo].size == 0) {
			throw new Exception("Empty Stack");
		}
		out = value[(stack[stackNo].start + stack[stackNo].size - 1) % value.length];
		stack[stackNo].size--;
		return out;
	}

	public int peek(int stackNo) throws Exception {
		int out;
		out = value[stack[stackNo].size - 1];
		return out;
	}

	private void expand(int stackNo) {

		int next = (stackNo + 1) % stack.length;
		if (stack[next].size == stack[next].capacity) {
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

			count += st.size;
		}
		return count == value.length;
	}

}
