package leet.code.random;

import java.util.Stack;

public class LC503NextGreaterElementII {

	/*
	 * O(n^2)
	public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] res = new int[n];
        for(int i = 0 ;i < n;i++){
            res[i]=-1;
            for(int j = 1 ;j<n; j++){
                if (nums[(i+j)%n]>nums[i]){
                    res[i] = nums[(i+j)%n];
                    break;
                } 
            }
            
        }
        return res;
    }
    */
	
    
  public int[] nextGreaterElements(int[] nums) {
     
      Stack<Integer> st = new Stack<Integer>();
      int n = nums.length;
      int [] res = new int[n];
      for(int i = (2*n)-1; i>=0; i-- )
      {
         
          while(!st.isEmpty() && nums[st.peek()]<=nums[i%n]) st.pop();
          res[i%n]= st.isEmpty() ?-1 : nums[st.peek()];
          st.push(i%n);
         
      }
      return res;
  }
  //same as above stack storing vlues in this instead of index
	 public int[] nextGreaterElements2(int[] nums) {
	        
	        Stack<Integer> st = new Stack<Integer>();
	        int n = nums.length;
	        int [] res = new int[n];
	        for(int i = (2*n)-1; i>=0; i-- )
	        {
	            
	            while(!st.isEmpty() && st.peek()<=nums[i%n]) st.pop();
	            res[i%n]= st.isEmpty() ?-1 : st.peek();
	            st.push(nums[i%n]);
	            
	        }
	        return res;
	    }
	
}
