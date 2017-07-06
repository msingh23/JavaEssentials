/**
 * 
 */
package ctci.chap8;

/**
 * @author manu
 *
 */
public class TripleStep {

	/*
	 * if n = 3 [1,1,1], [1,2], [2,1], [3]
	 * 
	 * if n=4 [1,1,1,1], [1,1,2], [1,2,1], [1,3], [2,1,1], [2,2] , [3,1]
	 * 
	 * if n = 5 [1,1,1,1,1], [1,1,1,2] [1,1,2,1] [1,2,1,1] [1,2,2] [2,1,1,1]
	 * [2,1,2] [2,2,1] [2,3] [3,1,1] [3,2]
	 * 
	 */

	public int getStepWays(int n) {
		int total = 0;
		StringBuffer buff = new StringBuffer();
		return getStepWaysHelper(0, n, total, buff);
	}

	private int getStepWaysHelper(int curr, int n, int total, StringBuffer buff) {
		if (curr > n) {
			// buff.delete(buff.length()-2, buff.length());
			return 0;
		}
		if (curr == n) {
			// System.out.println(buff.toString());
			// buff.delete(buff.length()-2, buff.length());
			return 1;
		}

		for (int i = 1; i < 4; i++) {
			buff.append(i + ",");
			total += getStepWaysHelper(curr + i, n, 0, buff);
			buff.delete(buff.length() - 2, buff.length());
		}
		return total;

	}

	public int getStepWaysRecurse(int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}

		return getStepWaysRecurse(n - 1) + getStepWaysRecurse(n - 2) + getStepWaysRecurse(n - 3);
	}

	public int getStepWaysRecurseMemoization(int n) {
		
		return getStepWaysRecurseMemoizationHelper(n, new int [n+1]);
	}

	private int getStepWaysRecurseMemoizationHelper(int n, int[] mem) {
		
		if(n == 0 )
		{
			return 1;
		}
		if(n < 0)
		{
			return 0;
		}
		
		if(mem[n]==0){
			mem[n] = getStepWaysRecurseMemoizationHelper(n-1, mem) + getStepWaysRecurseMemoizationHelper(n-2, mem) +getStepWaysRecurseMemoizationHelper(n-3, mem);
		}
		return mem[n];
	}
	
	public int getStepWaysIterative(int n) {
		
		int a = 1;
		int b = 2;
		int c = 4;
		int z = 0;
		if(n<0) return n;
		if(n==0) return 0;
		if(n ==1) return a;
		if(n==2) return b;
		if(n==3) return c;
		for(int i = 4; i <=n; i++)
		{
			z = a+b+c;
			a = b;
			b = c;
			c = z;
		}
		return z;
	}
	
}
