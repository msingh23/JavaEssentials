/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC396RotateFunction {

	 /*
	  * O(n^2)
    public int maxRotateFunction(int[] A) {
        
        int max = Integer.MIN_VALUE;
        int n = A.length;
        if( 0 == n) return 0;
        for(int i = 0 ; i< n;i++)
        {
            int point = n-i;
            int sum = 0;
            int index = 0;
            for(int j = point ; j < n ;j++)
            {
                sum += ((index++) * A[j]);
            }
            
            for(int j = 0 ; j<point; j++)
            {
                sum += ((index++) * A[j]);
            }
            
            max = Math.max(max, sum);
        }
        
        return (int) max;
            
    }
    */
    
	/*
	 * O(n) Mathematical 
	 * F(n) = Sum + F(n-1) - (A(len-n)*len )
	 * 
	 */
     public int maxRotateFunction(int[] A) 
     {
         
         int n = A.length , sum = 0, iteration =0, maxSum = Integer.MIN_VALUE;
         if(n == 0) return 0;
         for(int i  = 0; i <n; i++)
         {
             sum+=A[i];
             iteration+=( i * A[i]);
         }
         
         maxSum = Math.max(maxSum, iteration);
         
         for(int i = 1; i< n ;i++)
         {
             iteration = iteration  + sum - (n * A[n-i]);
             maxSum = Math.max(maxSum, iteration);
         }
         return maxSum;
     }
	
}
