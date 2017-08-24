/**
 * 
 */
package leet.code.random;

import java.util.Random;

/**
 * @author manu
 *
 */
public class LC324WiggleSortII {

	   public void wiggleSort(int[] nums) {
	        
	        int median = findKthLargest(nums, nums.length/2);
	        /*
	      org ind   0 1 2 3 4 5
	      nex ind   1 3 5 0 2 4 
	      oddSpot = 0 as nextIndex(0) = 1 , nextIndex(1) = 3 etc
	      evenSpot = n as nextIndex(5) = 4 , nextIndex(5) = 2 etc
	      smaller elemtns will take evenSpots, larger will take oddSpots.
	        */
	        
	        int n = nums.length;
	    
	        /*
	         int left = 0, i = 0, right = n - 1;

	        while (i <= right) {

	            if (nums[newIndex(i,n)] > median) {
	                swap(nums, newIndex(left++,n), newIndex(i++,n));
	            }
	            else if (nums[newIndex(i,n)] < median) {
	                swap(nums, newIndex(right--,n), newIndex(i,n));
	            }
	            else {
	                i++;
	            }
	        }
	        */
	        
	        int oddSpot = 0;
	        int evenSpot =n- 1;
	        int i = 0;
	        while(i<=evenSpot)
	        {
	             if(nums[newIndex(i,n)]>median)
	             {
	                 swap(nums,newIndex(i,n),newIndex(oddSpot,n));
	                 oddSpot++;
	             }
	            else if(nums[newIndex(i,n)]<median)
	            {
	                swap(nums,newIndex(i,n),newIndex(evenSpot,n));
	                evenSpot--;
	                i--;
	            }
	            i++;
	        }
	        
	        
	    }
	    
	    public int newIndex(int i, int n)
	    {
	        return (1+(2*i)) % (n | 1);
	    }
	    
	       public int findKthLargest(int[] nums, int k) {
	     
	        k = nums.length-k;
	        int start = 0;
	        int end = nums.length-1;
	         shuffle(nums);
	        while(start<=end)
	        {
	            int pivot = getPivot(nums, start, end);
	            if(k<pivot)
	            {
	                end = pivot-1;
	            }
	            else if (k>pivot)
	            {
	                start = pivot + 1;
	            }
	            else 
	            {
	                return nums[k];
	            }
	        }
	         
	     return -1;
	     }
	    
	    public int getPivot(int [] nums, int start, int end)
	    {
	        int pivot = start;
	        int i = start+1;
	        int j = end;
	        
	        while(i<=j)
	        {
	           if(nums[i]<=nums[pivot]){
	               i++;
	               continue;
	           }
	            if(nums[j]>=nums[pivot])
	            {
	                j--;
	                continue;
	            }
	            swap(nums,i,j);
	        }
	        swap(nums, pivot, j);
	        return j;
	    }
	    
	    public void swap(int [] inp, int i, int y)
	    {
	        int temp = inp[i];
	        inp[i] = inp[y];
	        inp[y] = temp;
	    }
	    private void shuffle(int a[]) {

	        final Random random = new Random();
	        for(int ind = 0; ind < a.length; ind++) {
	            final int r = random.nextInt(ind + 1);
	            swap(a, ind, r);
	        }
	    }
}
