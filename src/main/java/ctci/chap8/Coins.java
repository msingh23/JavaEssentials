/**
 * 
 */
package ctci.chap8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author manu
 *
 */
public class Coins {

	public enum coins {
		quarter(25), dime(10), nickel(5), penny(1);

		int value;

		coins(int cent) {
			this.value = cent;
		}

		int getValue() {
			return value;
		}
	}

	public ArrayList<ArrayList<coins>> representCents(int cent) {
		ArrayList<ArrayList<coins>> out = new ArrayList<ArrayList<coins>>();
		ArrayList<coins> curr = new ArrayList<coins>();
		representCentsHelper(cent, 0, out, curr, 0);
		return out;
	}

	private void representCentsHelper(int amount, int val, ArrayList<ArrayList<coins>> out, ArrayList<coins> curr,
			int index) {

		if (val >= amount) {
			if (val == amount) {
				ArrayList<coins> temp = new ArrayList<coins>(curr);
				out.add(temp);
			}
		} else {
			for (int i = index; i < 4; i++) {

				if (i == 0) {
					curr.add(coins.quarter);
					representCentsHelper(amount, val + coins.quarter.value, out, curr, i);
					curr.remove(curr.size() - 1);
				} else if (i == 1) {
					curr.add(coins.dime);
					representCentsHelper(amount, val + coins.dime.value, out, curr, i);
					curr.remove(curr.size() - 1);
				} else if (i == 2) {
					curr.add(coins.nickel);
					representCentsHelper(amount, val + coins.nickel.value, out, curr, i);
					curr.remove(curr.size() - 1);
				} else if (i == 3) {
					curr.add(coins.penny);
					representCentsHelper(amount, val + coins.penny.value, out, curr, i);
					curr.remove(curr.size() - 1);
				}

			}
		}

	}

	public ArrayList<ArrayList<coins>> representCentsMemoization(int cent) {
		HashMap<Integer, ArrayList<ArrayList<coins>>> mem = new HashMap<Integer, ArrayList<ArrayList<coins>>>();
		return representCentsMemoizationHelper(cent, cent, mem);
	}

	private ArrayList<ArrayList<coins>> representCentsMemoizationHelper(int total, int curr,
			HashMap<Integer, ArrayList<ArrayList<coins>>> mem) {
		// TODO Auto-generated method stub

		if (curr <= 0) {
			if (curr == 0) {
				ArrayList<coins> list = new ArrayList<coins>();
				ArrayList<ArrayList<coins>> out = new ArrayList<ArrayList<coins>>();
				out.add(list);
				mem.put(0, out);
			} else {
				return null;
			}

		} else {
			if (!mem.containsKey(curr)) {
				mem.put(curr, new ArrayList<ArrayList<coins>>());
				for (int i = 0; i < 4; i++) {
					ArrayList<ArrayList<coins>> prev = null;
					if (i == 0) {
						prev = representCentsMemoizationHelper(total, curr - coins.penny.value, mem);
						if (prev != null) {
							for (ArrayList<coins> coin : prev) {
								ArrayList<coins> temp = new ArrayList<>(coin);
								temp.add(coins.penny);
								mem.get(curr).add(temp);
							}

						}
					} else if (i == 1) {
						prev = representCentsMemoizationHelper(total, curr - coins.nickel.value, mem);
						if (prev != null) {
							for (ArrayList<coins> coin : prev) {
								ArrayList<coins> temp = new ArrayList<>(coin);
								temp.add(coins.nickel);
								mem.get(curr).add(temp);
							}
						}
					} else if (i == 2) {
						prev = representCentsMemoizationHelper(total, curr - coins.dime.value, mem);
						if (prev != null) {
							for (ArrayList<coins> coin : prev) {
								ArrayList<coins> temp = new ArrayList<>(coin);
								temp.add(coins.dime);
								mem.get(curr).add(temp);
							}
						}
					} else if (i == 3) {
						prev = representCentsMemoizationHelper(total, curr - coins.quarter.value, mem);
						if (prev != null) {
							for (ArrayList<coins> coin : prev) {
								ArrayList<coins> temp = new ArrayList<>(coin);
								temp.add(coins.quarter);
								mem.get(curr).add(temp);
							}
						}
					}
					// if(prev!=null){
					// mem.get(curr).add(prev);
					// //mem.put(curr, );
					// }
				}

			}

		}
		return mem.get(curr);
	}

	public ArrayList<ArrayList<Integer>> representCentsSimple(int n) {
		int[] denom = new int[] { 1, 5, 10, 25 };
		// ArrayList<ArrayList<Integer>> out = new
		// ArrayList<ArrayList<Integer>>();
		HashMap<Integer, ArrayList<ArrayList<Integer>>> mem = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
		representCentsSimpleHandler(n, n, mem, 0, denom);
		return mem.get(n);
	}

	private void representCentsSimpleHandler(int val, int change, HashMap<Integer, ArrayList<ArrayList<Integer>>> mem, int index, int[] denom) {
		
		ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
		if(change<0){
			return;
		}
		if(change ==0)
		{
			out.add(new ArrayList<Integer>());
			mem.put(change, out);
		}
		else{
			if(!mem.containsKey(change))
			{
				for(int i = index; i<denom.length; i++ ){
					
					representCentsSimpleHandler(val, change - denom[i], mem, index, denom);
					
					if(mem.containsKey(change - denom[i])){
						
						for(ArrayList<Integer> prev : mem.get(change - denom[i])){
							ArrayList<Integer> temp = new ArrayList<Integer>(prev);
							if(temp.size() >0 && temp.get(temp.size()-1)>denom[i]) break;
							temp.add(denom[i]);
							out.add(temp);
						}
						mem.put(change, out);
					}
				}
			}
		}
		
	}
	

	public int getWays(int n)
	{
		int [][] mem = new int [n+1][1];
		int denom [] = new int [] {1,5, 10, 25};
		return getWaysHelper(n , n , mem, denom, 0);
	}

	private int getWaysHelper(int total, int change, int[][] mem, int[] denom, int index) {

		if(change< 0){
			
			return 0;
		}
		if(change == 0){
			mem[change][0] =1;
			return 1;
		}
		if(mem[change][0] ==0){
			int ways = 0;
			for(int i = index; i < denom.length; i ++)
			{
				if(change>= denom[i]  ){
					int childWays = getWaysHelper(total, change-denom[i], mem, denom, index);
					if(i==0 || change- denom[i]< denom[i-1] ){
						ways+=childWays;
					}else{
						ways = ways + childWays-mem[change- denom[i-1]][0] +1 ;
					}
				}
				
			}
			mem[change][0] = ways;
		}
		
		
		return mem[change][0];
	}
	
	int count( int S[], int m, int n )
	{
	    // If n is 0 then there is 1 solution (do not include any coin)
	    if (n == 0)
	        return 1;
	     
	    // If n is less than 0 then no solution exists
	    if (n < 0)
	        return 0;
	 
	    // If there are no coins and n is greater than 0, then no solution exist
	    if (m <=0 && n >= 1)
	        return 0;
	 
	    // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
	    return count( S, m - 1, n ) + count( S, m, n-S[m-1] );
	}
	
	static long countWays(int S[], int m, int n)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)
 
        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n+1];
 
        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)
 
        // Base case (If given value is 0)
        table[0] = 1;
 
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];
 
        return table[n];
    }
	
	public int countWaysGeeks(int n)
	{
		int [] denom = new int [] {1,5,10,25};
		return countWaysGeeksHelper2(denom,0,n, new int[n+1] );
		//return countWaysGeeksHelper(denom,0,n, new int[n+1][denom.length] );
	}
	
	private int countWaysGeeksHelper(int[] denom, int i, int n, int [] []mem) {
		
		if(i>=denom.length){
			return 0;
		}
		if(n ==0){
			return 1;
		}
		if(n<0){
			return 0;
		}
		if(mem[n][i] ==0){
			mem[n][i] = countWaysGeeksHelper(denom, i+1, n, mem) +countWaysGeeksHelper(denom, i, n-denom[i],mem);
		}
		return mem[n][i];
		
	}
	
	/*
	 * this is incorrect because the mem[] records the first value that is stored in the tree
	 * eg if we traverse to find 6 with coins (5,10,15), we get mem[5] =1 as 6 : (5,10,15) --> 5 : (5,10,15)
	 * and then 6: (1,5,10,15) = 5: (1,5,10,15) + 6: (5,10,15)
	 * i.e 						mem(5)          + mem ()
	 */
private int countWaysGeeksHelper2(int[] denom, int i, int n, int []mem) {
		
		if(i>=denom.length){
			return 0;
		}
		if(n ==0){
			return 1;
		}
		if(n<0){
			return 0;
		}
		if(mem[n] ==0){
			mem[n] = countWaysGeeksHelper2(denom, i+1, n, mem) + countWaysGeeksHelper2(denom, i, n-denom[i],mem);
		}
		return mem[n];
		
	}

	public static void main(String[] args) {
		Coins c = new Coins();
		//System.out.println(c.getWays(99));
		System.out.println(c.countWaysGeeks(6));
//		System.out.println(c.countWays(new int []{1,25,5,10},4, 14));
//		System.out.println(c.count(new int []{25,10,5,1},4, 14));
	}
	

}
