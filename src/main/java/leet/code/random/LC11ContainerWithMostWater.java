/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC11ContainerWithMostWater {

	/*
    public int maxArea(int[] height) {
        
        int max = 0;
        
        for(int i = 0; i<height.length ;i++)
        {
            for(int j = i+1; j <height.length; j++)
            {
                
                int distance = j-i;
                int vol  = Math.min(height[i], height[j]) * distance;
                max = Math.max(vol,max);
                
            }
        }
            
            return max;
            
    }
    */
    
     public int maxArea(int[] height)
     {
         int left  = 0;
         int right = height.length-1;
         int maxVol = 0;
         
         while(left<right)
         {
             int distance = right-left;
             int sum = Math.min(height[left], height[right]) * distance;
             maxVol = Math.max(sum, maxVol);
             if(height[left] == height[right]) 
             {
                 left++; right--;
             }
             else if(height[left] < height[right]) left++;
             else right--;
         }
         return maxVol;
     }
}
