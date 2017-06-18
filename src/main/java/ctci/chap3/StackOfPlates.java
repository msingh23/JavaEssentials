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
			Node next;

			public Node(int data) {
				this.data = data;
				this.next = null;

			}
		}

		public Stack(int data) {
			Node temp = new Node(data);
			head = temp;
			this.size = 1;
		}
	}

	public StackOfPlates(int capacity) {
		list = new ArrayList<Stack>();
		this.capacity = capacity;
	}

	public void push(int data) {
		if (list.size() == 0 || list.get(list.size() - 1).size == capacity) {
			Stack st = new Stack(data);
			list.add(st);
			return;
		}
		Stack curr = list.get(list.size() - 1);
		Node temp = curr.new Node(data);
		temp.next = curr.head;
		curr.head = temp;
		curr.size++;
	}

	public int pop() throws Exception {
		if (list.size() == 0) {
			throw new Exception("Stack is empty");
		}
		Stack curr = list.get(list.size() - 1);
		int data = curr.head.data;
		curr.head = curr.head.next;
		if (curr.head == null) {
			list.remove(list.size() - 1);
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

}
