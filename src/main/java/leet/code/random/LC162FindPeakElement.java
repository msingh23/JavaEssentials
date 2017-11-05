package leet.code.random;

public class LC162FindPeakElement {
	 /*
    public int findPeakElement(int[] nums) {
        int peak =0;
        for(int i = 1 ;i<nums.length;i++)
        {
            if(nums[i]>nums[peak])
                peak=i;
        }
        
        return peak;
    }
    */
    
     public int findPeakElement(int[] nums) {
         int start = 0 , end = nums.length-1;
         while(start<end)
         {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1])
            end = mid;
        else if (nums[mid] < nums[mid + 1])
            start = mid + 1;
                 
         }
         return end;
     }
}
