/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC81SearchinRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
	    int lo = 0;
	    int hi = A.length - 1;
	    while (lo <= hi) {
	        int mid = (lo + hi) / 2;
	        if (A[mid] == target) return true;
	        if(A[lo] == A[hi]) lo++;
	        else if (A[lo] <= A[mid]) {
	            if (target >= A[lo] && target < A[mid]) {
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        } else {
	            if (target > A[mid] && target <= A[hi]) {
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	    }
	    return false;
	    }
}
