/**
 * 
 */
package leet.code.random;

import java.util.PriorityQueue;

/**
 * @author manu
 *
 */
public class KthSmallestElementinaSortedMatrix378 {

	public int kthSmallest(int[][] matrix, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// important to make ize k+1 as if the first k elements are
				// encountered first
				// then it will remove the kth element on k+1 iteration which is
				// the anser.
				// making k+1 will preserve the value of k.
				if (pq.size() > k) {
					pq.poll();
				}
				pq.add(matrix[i][j]);
			}
		}
		if (pq.size() > k)
			pq.poll();
		return pq.poll();

	}
}
