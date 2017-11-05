/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC279PerfectSquares {

	public int numSquares(int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;
        //dp[1] = 1;
        
        for(int i = 1 ; i <= n; i++)
        {
            int j = 1;
            dp[i] = Integer.MAX_VALUE;
            while((i - j*j)>=0 )
            {
                dp[i] = Math.min(dp[i], dp[i - j*j] +1);
                j++;
            }
        }
        
        return dp[n];
    }
}
