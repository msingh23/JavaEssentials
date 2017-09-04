/**
 * 
 */
package leet.code.random;

import java.util.Stack;

/**
 * @author manu
 *
 */
public class LC42TrappingRainWater {

	
	/*
	 * n^2
	
	 public int trap(int[] height)
     {
    
         int total =0;
         for(int i = 1; i < height.length - 1; i++)
         {
             int left = i-1;
             int right = i+1;
             int leftMax = height[i];
             while(left >=0 )
             {
                 leftMax = Math.max(leftMax, height[left--]);
             }
             int rightMax = height[i];
             while(right <height.length )
             {
                 rightMax = Math.max(rightMax, height[right++]);
             }
            
             total += Math.min(leftMax ,rightMax ) - height[i];
             
         }
     
         return total;
     }
	 
	 */
	 /*
	    using Dp we can computer the max left height and max right height for all heights and then computer the same.
	    
	     public int trap(int[] height)
	     {
	         int n = height.length;
	         if(n==0) return 0;
	         int total = 0;
	         int [] leftMem = new int [n], rightMem = new int[n];
	         
	         int start = 0, end = n-1;
	         leftMem[0] = height[0];
	         rightMem[n-1] = height[n-1];
	         
	         int left = start+1, right = end-1;
	         while(left<n)
	         {
	             leftMem[left] =Math.max(height[left], leftMem[left-1]);
	             left++;
	         }
	         
	         while(right>=0)
	         {
	             rightMem[right] = Math.max(height[right], rightMem[right+1]);
	             right--;
	         }
	         
	        
	         for(int i = 0 ; i<n; i ++)
	         {
	             total+=Math.min(leftMem[i], rightMem[i]) - height[i];
	         }
	         
	         return total;
	     }
	    */
	    
	/*
	     //using stack
	     //  1. add the elelemt if it is less than the head of the stack
	      // 2. if it is greator than or equal the head of stack then do
	       //  diff of the height  * (difference of indices -1); but only if ther eare two or more in stack.
	       // 
	       
	        public int trap(int[] height)
	        {
	            Stack<Integer> st = new Stack<Integer>();
	            int count = 0;
	            int n = height.length;
	            
	            for(int i = 0 ; i <  n ; i++)
	            {
	                while(!st.isEmpty() && height[st.peek()]<height[i])
	                {
	                    
	                    int top = st.pop();
	                    if(st.isEmpty()) break;
	                    
	                    int diff = i - st.peek() -1;
	                    count += ((Math.min(height[st.peek()],height[i] ) - height[top] ) * diff);
	                    
	                }
	                
	                    st.push(i);
	                
	            }
	            
	            return count;
	        }
	       */ 
	      //using pointers
	        // for every index maintain left max and right max
	        // if left is less than right then count + = mathmin(left, left_max) - left; left ++; also update left_max
	         // similar for rightmax until left < right;
	        
	         public int trap(int[] height)
	         {
	             int n = height.length;
	             if(n<3) return 0; 
	             int left = 0;
	             int right = n-1;
	             int count = 0;
	             int leftMax = height[left];
	             int rightMax = height[right];
	             while(left<right)
	             {
	                 if(height[left]<height[right])
	                 {
	                     leftMax = Math.max(leftMax, height[left]);
	                     count+= leftMax - height[left];
	                     left++;
	                 } 
	                 else 
	                 {
	                     rightMax = Math.max(rightMax, height[right]);
	                     count+=  rightMax - height[right];
	                     right--;
	                 }
	             }
	             return count;
	             
	         }
	        
	    public static void main(String[] args) {
			
	    	LC42TrappingRainWater lc = new LC42TrappingRainWater();
	    	System.out.println(lc.trap(new int []{0,2,0}));
	    	
		}
	    
	
}
