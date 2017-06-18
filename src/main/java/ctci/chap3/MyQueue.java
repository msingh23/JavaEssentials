/**
 * 
 */
package ctci.chap3;

import ctci.chap2.Node;
import ctci.chap3.Stack.StackNode;

/**
 * @author manu
 *
 */
public class MyQueue<T> {

	public Stack<T> st1;
	public Stack<T> st2;

	public MyQueue() {
		st1 = new Stack<T>();
		st2 = new Stack<T>();
	}

	public void enqueue(T data) {
		st1.push(data);
	}

	public boolean isEmpty() {
		if (st1.isEmpty() && st2.isEmpty())
			return true;
		return false;
	}

	public T dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("queue is empty");
		}
		if (st2.isEmpty()) {
			while (!st1.isEmpty()) {
				st2.push(st1.pop());
			}
		}
		return st2.pop();

	}

	public T peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("queue is empty");
		}
		if (st2.isEmpty()) {
			while (!st1.isEmpty()) {
				st2.push(st1.pop());
			}
		}
		return st2.peek();
	}

}
