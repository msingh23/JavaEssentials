/**
 * 
 */
package ctci.chap4;

/**
 * @author manu
 *
 */
public class PriorityQueue<T> {

	public int capacity;
	public int size;
	public boolean min;
	public boolean max;
	public HeapNode[] heap;

	public class HeapNode<T> {

		public T data;
		public int priority;

		public HeapNode(T data, int priority) {
			this.data = data;
			this.priority = priority;

		}
	}

	public PriorityQueue(int capacity, int type) {
		this.capacity = capacity;
		heap = new HeapNode[capacity];
		size = 0;
		if (type == 0) {
			min = true;
			max = false;
		} else if (type == 1) {
			max = true;
			min = false;
		}
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
		size++;
		moveUp(size - 1);
	}

	public void moveUp(int index) {
		int parent = getParent(index);
		if (min) {
			if (parent != -1 && heap[index].priority < heap[parent].priority) {
				swap(index, parent);
				moveUp(parent);
			}
		} else if (max) {
			if (parent != -1 && heap[index].priority > heap[parent].priority) {
				swap(index, parent);
				moveUp(parent);
			}
		}
	}

	private void swap(int i, int j) {
		HeapNode temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;

	}

	private void resize() {
		int newCapacity = 2 * this.capacity;
		HeapNode[] newHeap = new HeapNode[newCapacity];
		for (int i = 0; i < this.heap.length; i++) {
			newHeap[i] = this.heap[i];
		}
		this.capacity = newCapacity;
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

	public HeapNode peek() throws Exception {
		if (size == 0) {
			throw new Exception("priority is empty");
		}
		return heap[0];
	}

	public void moveDown(int i) {
		int left = getLeft(i);
		int right = getRight(i);
		int ind = i;
		if (min) {
			if (left != -1 && heap[left].priority < heap[ind].priority) {
				ind = left;
			}
			if (right != -1 && heap[right].priority < heap[ind].priority) {
				ind = right;
			}

		} else if (max) {
			if (left != -1 && heap[left].priority > heap[ind].priority) {
				ind = left;
			}
			if (right != -1 && heap[right].priority > heap[ind].priority) {
				ind = right;
			}

		}
		if (ind != i) {
			swap(ind, i);
			moveDown(ind);
		}

	}
}
