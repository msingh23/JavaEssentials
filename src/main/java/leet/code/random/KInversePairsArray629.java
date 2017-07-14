/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class KInversePairsArray629 {

	//brute force
	public int kInversePairs(int n, int k) {
		Integer[][] mem = new Integer[n + 1][k + 1];
		return kInversePairsHelper(n, k, mem);
	}

	public int kInversePairsHelper(int n, int k, Integer[][] mem) {
		if (n == 0)
			return 0;
		if (k == 0)
			return 1;
		if (mem[n][k] != null)
			return mem[n][k];
		mem[n][k] = 0;
		int val = 0;
		for (int i = 0; i <= Math.min(k, n - 1); i++) {
			mem[n][k] += kInversePairs(n - 1, k - i);
		}
		return mem[n][k];
	}
}
