/**
 * 
 */
package leet.code.random;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author manu
 *
 */
public class KthLargestElementinanArray215 {

	 /*
    nlogk
    
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxH = new PriorityQueue<Integer>((a,b)->a-b);
        for(int i = 0 ; i<nums.length; i++){
            maxH.add(nums[i]);
            if(maxH.size()>k){
                maxH.poll();
            }
        }
        return maxH.peek();
    }
    
    */
    
    /*
    log(n)
    */
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
