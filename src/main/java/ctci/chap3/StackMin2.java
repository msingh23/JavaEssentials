/**
 * 
 */
package ctci.chap3;

/**
 * @author manu
 *
 */
public class StackMin2 extends StackMin {
	StackNode head;

	public StackMin2(int data) {
		super(data);
		head = new StackNode(data);

	}

	public void push(int data) {
		if (head.data > data) {
			StackNode temp = new StackNode(data);
			temp.next = head;
			head = temp;
		}
		super.push(data);
	}

	public int pop() throws Exception {
		int out = super.pop();
		if (out == head.data) {
			head = head.next;
		}
		return out;
	}
	public int min() {
		return head.data;
	}
}
