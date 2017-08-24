/**
 * 
 */
package leet.code.random;

import java.util.PriorityQueue;

/**
 * @author manu
 *
 */
public class LC378KthSmallestElementInASortedMatrix {
	/*
	 * N^2logk
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
	*/
	 /*
	    *nlogk
	    */
	    public class Tuple{
	        int x; int y; int val;
	        
	        public Tuple(int x, int y, int val){
	            this.x = x;
	            this.y = y;
	            this.val = val;
	        }
	    }
	    
	    public int kthSmallest(int[][] matrix, int k){
	        
	        int n = matrix.length;
	        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((a,b)->a.val-b.val);
	        
	        for(int i =0 ; i<n; i++ )
	        {
	            pq.add(new Tuple(0, i, matrix[0][i]));
	        }
	        
	        for(int i =1;i< k; i++){
	            Tuple low = pq.poll();
	            if(low.x==n-1) continue;
	            pq.add(new Tuple(low.x+1, low.y, matrix[low.x+1][low.y]));
	        }
	        return pq.poll().val;
	    }
}
