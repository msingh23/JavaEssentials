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
	boolean min;
	boolean max;
	HeapNode[] heap;

	public class HeapNode<T> {

		T data;
		int priority;

		public HeapNode(T data, int priority, int type) {
			this.data = data;
			this.priority = priority;
			if (type == 0) {
				min = true;
				max = false;
			} else {
				max = true;
				min = false;
			}
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

	public void insert(HeapNode node) {
		if (size == capacity) {
			resize();
		}
		heap[size] = node;
		moveUp(size);
		size++;
	}

	private void moveUp(int index) {
		int parent = getParent(index);
		if (min) {
			if (parent != -1 && heap[index].priority < heap[parent].priority) {
				swap(heap[index], heap[parent]);
				moveUp(parent);
			}
		} else if (max) {
			if (parent != -1 && heap[index].priority > heap[parent].priority) {
				swap(heap[index], heap[parent]);
				moveUp(parent);
			}
		}
	}

	private void swap(HeapNode heapNode, HeapNode heapNode2) {
		HeapNode temp = heapNode;
		heapNode = heapNode2;
		heapNode2 = temp;

	}

	private void resize() {
		int newCapacity = 2 * this.capacity;
		HeapNode[] newHeap = new HeapNode[newCapacity];
		for (int i = 0; i < this.heap.length; i++) {
			newHeap[i] = this.heap[i];
		}
		this.heap = newHeap;

	}

	public HeapNode extractTop() throws Exception {
		HeapNode top;
		if (size == 0) {
			throw new Exception("priority is empty");
		}
		top = heap[0];
		heap[0] = heap[size - 1];
		size--;
		moveDown(0);
		return top;

	}

	private void moveDown(int i) {
		int left = getLeft(i);
		int right = getRight(i);
		if (min) {
			if (left != -1 && heap[left].priority < heap[i].priority) {
				swap(heap[left], heap[i]);
				moveDown(left);
			} else if (right != -1 && heap[right].priority < heap[i].priority) {
				swap(heap[right], heap[i]);
				moveDown(right);
			}

		} else if (max) {
			if (left != -1 && heap[left].priority > heap[i].priority) {
				swap(heap[left], heap[i]);
				moveDown(left);
			} else if (right != -1 && heap[right].priority > heap[i].priority) {
				swap(heap[right], heap[i]);
				moveDown(right);
			}

		}
	}
}
