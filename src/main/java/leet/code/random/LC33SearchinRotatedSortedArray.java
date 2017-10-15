/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC33SearchinRotatedSortedArray {

	 /*
    public int search(int[] nums, int target) {
        
        int pivot = binarySearchPivot(nums, 0 , nums.length-1);
        //System.out.println(pivot);
        if(pivot !=-1)
        {
           return  Math.max( binarySearch(nums, 0 , pivot-1, target), binarySearch(nums, pivot , nums.length-1, target));
            
        }
        return binarySearch(nums, 0 , nums.length-1, target);
        
    }
    
    public int binarySearch(int [] nums, int start, int end, int target)
    {
       
        if(start<=end)
        {
            
            int mid = start +  ( end- start ) /2 ;
             //System.out.println(mid);
            if(nums[mid] == target) return mid;
            
            else if(nums[mid] > target) return binarySearch(nums, start, mid -1, target);
            else return binarySearch(nums, mid+1, end, target);
            
        }
        
        
        return -1;
    }
    
    public int binarySearchPivot(int [] nums, int start, int end)
    {
         // System.out.println(start + " "+ end);
        if(start<=end)
        {
            
            int mid = start +  ( end- start ) /2 ;
            if(mid > 0 && nums[mid-1] > nums[mid]) return mid;
            if(mid<nums.length-1 && nums[mid+1] < nums[mid]) return mid+1; 
            
            else if(nums[start] > nums[mid]) return binarySearchPivot(nums, start, mid -1);
            else return binarySearchPivot(nums, mid+1, end);
            
        }
        
        
        return -1;
    }
    */
	
	public int search(int[] A, int target) {
	    int lo = 0;
	    int hi = A.length - 1;
	    while (lo <= hi) {
	        int mid = (lo + hi) / 2;
	        
	        if (A[mid] == target) return mid;
	        
	        if (A[lo] <= A[mid]) {
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
	    return -1;
	}
	
}
