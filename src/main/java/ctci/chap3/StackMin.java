package ctci.chap3;

public class StackMin {
	private StackNode head;

	public class StackNode {
		int data;
		int min;
		StackNode next;

		public StackNode(int data) {
			this.data = data;
			this.min = data;
			next = null;
		}
	}

	public StackMin(int data) {
		head = new StackNode(data);
	}

	public void push(int data) {
		StackNode temp = new StackNode(data);
		if (temp.min > head.min) {
			temp.min = head.min;
		}
		temp.next = head;
		head = temp;
	}

	public int pop() throws Exception {
		if (head == null) {
			throw new Exception("Stack is empty");
		}
		int out = head.data;
		head = head.next;
		return out;
	}

	public int peek() {
		return head.data;
	}

	public int min() {
		return head.min;
	}

}
