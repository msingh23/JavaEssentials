/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC238ProductofArrayExceptSelf {

	 /*
    [1,2,3,4]
    
    0 - 1
    1 - 2
    2 - 6
    3 - 24
    
    res = 24
    
    24 12 8 6
    0 1 2 3 
    
    
 
 */
 /*
 public int[] productExceptSelf(int[] nums) 
 {
     long prod = 1;
     int count = 0;
     for(int i : nums) 
     {
         if(i!=0)
         prod*=i;
         else{
             count++;
         }
     }
     
     for(int i = 0; i<nums.length; i++)
     {
         if(nums[i] != 0 ){
             if(count == 0)
             nums[i] = (int)prod/nums[i];
             else 
                 nums[i] =0;
         }
         
         else if(nums[i] == 0 && count ==1)
         {
             nums[i] = (int)prod;
         }
         else if(count>1)
         {
             nums[i] = 0;
         }
     }
     
     return nums;
 }
 */
 public int[] productExceptSelf(int[] nums) 
 {
     int [] res = new int [nums.length];
     
     int forward = 1;
     
     for(int i = 0 ; i<nums.length; i++)
     {
         forward*=nums[i];
         res[i] = forward;
     }  
     
     int backward = 1;
     
     for(int i = nums.length-1 ; i >=0 ; i--)
     {
         
         if(i > 0)
         {
             res[i] = res[i-1]*backward;
             backward*=nums[i];
         }else
         {
           res[i]=backward;  
         }
         
     }
     
     return res;
     
     
 }
	
}
