/**
 * 
 */
package ctci.chap3;

/**
 * @author manu
 *
 */
public class Queue<T> {

	private class QueueNode<T> {
		private T data;
		private QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
		}

	}

	private QueueNode<T> head;
	private QueueNode<T> tail;

	public void enqueue(T data) {
		QueueNode<T> temp = new QueueNode<T>(data);
		if (tail == null) {
			tail = temp;
			head = temp;
		} else {
			tail.next = temp;
			tail = temp;
		}

	}

	public T dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty, can't delete");
		}
		T out = head.data;
		if (head == tail) {
			tail = tail.next;
		}
		head = head.next;
		return out;

	}
	
	public T peek() throws Exception{
		if (isEmpty()) {
			throw new Exception("Queue is empty, can't peek");
		}
		return head.data;
	}

	public boolean isEmpty() throws Exception {
		if (tail != null && head != null) {
			return false;
		} else if (tail == null && head == null) {
			return true;
		} else {
			// this should never be thrown
			throw new Exception("Inconsistent Queue");
		}
	}

}
