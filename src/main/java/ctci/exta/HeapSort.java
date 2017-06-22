/**
 * 
 */
package ctci.exta;

import ctci.chap4.PriorityQueue;
import ctci.chap4.PriorityQueue.HeapNode;

/**
 * @author manu
 *
 */
public class HeapSort {

	public PriorityQueue<Integer> heap;

	public void sort(int[] inp, int asc) throws Exception {
		if (asc == 0) {
			heap = new PriorityQueue<>(inp.length, 1);
		} else if (asc == 1) {
			heap = new PriorityQueue<>(inp.length, 0);
		}
		heap.size = inp.length;
		for (int i = 0; i < inp.length; i++) {
			heap.heap[i] = heap.new HeapNode<Integer>(inp[i], inp[i]);
		}
		heapify(heap);
		for (int i = 0; i < inp.length; i++) {
			inp[inp.length - i - 1] = (int) heap.extractTop().data;

		}
	}

	private void heapify(PriorityQueue<Integer> heap2) {
		for (int i = (heap2.size - 1) / 2; i >= 0; i--) {
			heap2.moveDown(i);
		}

	}

}
