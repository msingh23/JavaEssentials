/**
 * 
 */
package leet.code.random;

import java.util.Stack;

/**
 * @author manu
 *
 */
public class LC84LargestRectangleinHistogram {

	 public int largestRectangleArea(int[] heights) {
	      
         int max = 0;
         Stack<Integer> st = new Stack<Integer>();
         int curr =0;
         while(curr < heights.length)
         {
             
             while(!st.isEmpty() && heights[st.peek()] >= heights[curr] )
             {
                 int maxIndx = st.pop();
                 int distance = curr ;
                 if(!st.isEmpty())
                 {
                    distance -= (st.peek() +1);
                 }
                 
                 max = Math.max(max, distance * heights[maxIndx]);
         
             }
                   st.add(curr++);
         }
         
         while(!st.isEmpty())
         {
             int maxIndx = st.pop();
             int distance = curr ;
             if(!st.isEmpty())
             {
                distance -= (st.peek() +1);
             }
             max = Math.max(max, distance * heights[maxIndx]);
         }
        
         
         return max;
     }
	
}
