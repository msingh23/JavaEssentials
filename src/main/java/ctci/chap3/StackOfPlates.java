/**
 * 
 */
package ctci.chap3;

import java.util.ArrayList;
import java.util.List;

import ctci.chap3.StackOfPlates.Stack.Node;

/**
 * @author manu
 *
 */
public class StackOfPlates {

	List<Stack> list;
	int capacity;

	public class Stack {

		Node head;
		int size;

		public class Node {
			int data;
			Node prev;
			Node next;

			public Node(int data) {
				this.data = data;
				this.next = null;
				this.prev = null;
			}
		}

		public Stack(int data) {
			Node temp = new Node(data);
			head = temp;
			this.size = 1;
		}

		public int pop() {
			int out = this.head.data;
			Node prev = head.prev;
			this.head = this.head.next;
			this.size--;
			if (this.head != null)
				this.head.prev = prev;
			return out;
		}

		public void push(int data) {
			Node temp = new Node(data);
			temp.next = this.head;
			head.prev = temp;
			this.head = temp;
			this.size++;

		}
	}

	public StackOfPlates(int capacity) {
		list = new ArrayList<Stack>();
		this.capacity = capacity;
	}

	public void push(int data) {
		if (list.size() == 0 || list.get(list.size() - 1).size == capacity) {
			Stack st = new Stack(data);
			if (list.size() != 0) {
				list.get(list.size() - 1).head.prev = st.head;
			}
			list.add(st);
			return;
		}
		Stack curr = list.get(list.size() - 1);
		curr.push(data);

	}

	public int pop() throws Exception {
		if (list.size() == 0) {
			throw new Exception("Stack is empty");
		}
		Stack curr = list.get(list.size() - 1);
		int data = curr.pop();
		if (curr.head == null) {
			list.remove(list.size() - 1);
			if (list.size() != 0) {
				list.get(list.size() - 1).head.prev = null;
			}
		}
		return data;
	}

	public int peek() throws Exception {
		if (list.size() == 0) {
			throw new Exception("Stack is empty");
		}
		return list.get(list.size() - 1).head.data;
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	public int popAt(int index) throws Exception {

		if (list.get(index) != null) {
			Stack curr = list.get(index);
			int data = curr.pop();
			shiftBack(index);
			return data;
		} else {
			throw new Exception("Stack doesn't exist or is empty");
		}
	}

	private void shiftBack(int index) {
		if (list.size() > index + 1) {
			Stack curr = list.get(index);
			Node prev = curr.head.prev;
			if (prev != null) {
				if(prev.prev!=null ){
					prev.prev.next = prev.next;
				}
				prev.next=curr.head;
				curr.head = prev;
				curr.size++;
				list.get(index + 1).size--;
				shiftBack(index + 1);
			}else{
				list.remove(index+1);
			}
			
		}

	}

}
