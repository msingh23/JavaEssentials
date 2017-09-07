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
		int n = coins.length;
		int dp[][] = new int[n + 1][amount + 1];
		dp[0][0] = 1;
		for (int i = 1; i < n + 1; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= amount; j++) {
				if ((j - coins[i - 1] >= 0))
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[n][amount];
	}

	public static void main(String[] args) {
		LC518CoinChange2 lc = new LC518CoinChange2();
		System.out.println(lc.change(500, new int[] { 1, 2, 5 }));
	}
}
