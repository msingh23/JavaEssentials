/**
 * 
 */
package ctci.chap3;

/**
 * @author manu
 *
 */
public class Stack<T> {

	private class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode(T data) {
			this.data = data;
			next = null;
		}
	}

	private StackNode<T> top;

	public void push(T data) {

		StackNode<T> temp = new StackNode<T>(data);
		temp.next = top;
		top = temp;

	}

	public T peek() throws Exception {
		if (top == null) {
			throw new Exception("Stack is empty");
		}
		return top.data;
	}

	public T pop() throws Exception {
		if (top == null) {
			throw new Exception("Stack is empty");
		}
		T out = top.data;
		top = top.next;
		return out;
	}

	public boolean isEmpty() {
		return (top == null);
	}
}
