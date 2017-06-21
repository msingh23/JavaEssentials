/**
 * 
 */
package ctci.chap4;

/**
 * @author manu
 *
 */
public class PriorityQueue<T> {

	int capacity;
	int size;
	HeapNode[] heap;

	public class HeapNode<T> {

		T data;
		int priority;

		public HeapNode(T data, int priority) {
			this.data = data;
			this.priority = priority;
		}
	}

	public PriorityQueue(int capacity) {
		heap = new HeapNode[capacity];
		size = 0;
	}

	private int getLeft(int i) {
		int left = 2 * i + 1;
		if (left >= size) {
			return -1;
		}
		return left;
	}

	private int getRight(int i) {
		int right = 2 * i + 2;
		if (right >= size) {
			return -1;
		}
		return right;
	}

	private int getParent(int i) {
		int parent = (i - 1) / 2;
		if (parent < 0) {
			return -1;
		}
		return parent;
	}

}
