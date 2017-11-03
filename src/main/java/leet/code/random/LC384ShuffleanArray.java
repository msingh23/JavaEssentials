/**
 * 
 */
package leet.code.random;

import java.util.Random;

/**
 * @author manu
 *
 */
public class LC384ShuffleanArray {

	  int [] base;
	    int range;
	    public LC384ShuffleanArray(int[] nums) {
	        base = nums;
	        range = nums.length;
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return base;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        Random random = new Random();
	        
	        if(range<2) return base;
	       
	        int [] baseClone = base.clone();
	        
	        for(int i = range-1; i>0; i--)
	        {
	            int j = random.nextInt(i+1);
	            
	            swap(baseClone, i, j);
	        }
	        
	        return baseClone;
	        // int[] a = base.clone();
	        // for(int j = 1; j < a.length; j++) {
	        //     int i = random.nextInt(j + 1);
	        //     swap(a, i, j);
	        // }
	        // return a;
	    }
	    
	    public void swap(int [] base, int f1, int f2)
	    {
	        int temp = base[f1];
	        base[f1] = base[f2];
	        base[f2] = temp;
	    }
}
