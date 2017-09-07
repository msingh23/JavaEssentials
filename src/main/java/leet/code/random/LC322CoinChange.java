/**
 * 
 */
package leet.code.random;

import java.util.Arrays;

/**
 * @author manu
 *
 */
public class LC322CoinChange {

	
	/*
	 * dp based n * m
	 */
	
	 public int coinChange(int[] coins, int amount) {
	       
         if(amount == 0) return 0;            
          int n = coins.length;
          int [] mem = new int [amount+1];
          
          Arrays.fill(mem, -1);
          mem[0] = 0;

        for(int i =1; i <= amount; i++)
          {
            int result  =-1;
            
            for(int z = 0; z< n; z++)
            { 
                if(coins[z]>i) continue;
                
                int amountRemain = i - coins[z];
                int remainResultCount = mem[amountRemain];
                
                if(remainResultCount!=-1)
                {
                    if(result!=-1) 
                        result = Math.min(result, 1 + remainResultCount );
                    else
                        result = 1 + remainResultCount;
                }
                
                
            }
            mem[i] = result;
  
          }

          return mem[amount];

  }   
	    public static void main(String[] args) {
			LC322CoinChange ls = new LC322CoinChange();
			System.out.println(ls.coinChange(new int []{186,419,83,408}, 6249));
		}
}
