/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC189RotateArray {

public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k = k % n;
        if(k ==0) return ;
        int count = 0;
        int i =0;
        int newVal = nums[i];
        int start = 0;
        while(count<n)
        {
            int nextIndex = (i + k) % n;
            if(nextIndex == start)
            {
                int temp = nums[nextIndex+1];
                nums[nextIndex] = newVal;
                newVal = temp;
                 i = nextIndex+1;
                 start = i;
            }else
            {
                  int temp = nums[nextIndex];
                  nums[nextIndex] = newVal;
                  newVal = temp;
                  i = nextIndex;
            }
          
            count++;
        }
        
    }
}
