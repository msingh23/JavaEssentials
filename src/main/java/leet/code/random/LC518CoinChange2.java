package leet.code.random;

public class LC518CoinChange2 {
	/*
	 * 3 [1,2,5]
	 * 
	 * 0:0 1:1 2: 1,1 2,0 = 2 3 = 2 + 1 = 2 1,1,1, 1,2 2,1 4 = 3 + 2 = 3 1,1,1,1
	 * 1,1,2 , 2,2 5 = 4 + 3 + 0 = 1 + 2 + 1
	 * 
	 */

	  public int change(int amount, int[] coins) {
	        
	        int r = coins.length+1;
	        int c = amount+1;
	        int dp [] []  = new int [r][c]; 
	        
	        for(int i = 0 ;i <r; i++)
	            dp[i][0] = 1;
	        
	            for(int i = 1 ; i<r ;i++)
	            {
	                int coin = coins[i-1];
	                for(int sum = 1; sum< c; sum++)
	                {
	                    dp[i][sum] =  dp[i-1][sum] + (sum<coin ? 0 : dp[i][sum-coin]);
	                }
	                System.out.println();
	            }
	        
	        return dp[r-1][c-1];
	        
	    }

	public static void main(String[] args) {
		LC518CoinChange2 lc = new LC518CoinChange2();
		System.out.println(lc.change(500, new int[] { 1, 2, 5 }));
	}
}
