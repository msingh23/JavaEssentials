/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class KInversePairsArray629 {

    public int kInversePairsDPx(int n, int k) {
        int [][] mem = new int [n+1][k+1];
        for(int i =1;i<=n;i++){
            for(int j = 0; j <=k;j++){
                if(j==0){
                    mem[i][j] =1;
                }else{
                    for(int p =0; p<=Math.min(j,i-1); p++)
                    mem[i][j]= (mem[i][j]+ mem[i-1][j-p])%  1000000007;
                }
            }
        }
        return mem[n][k];
        //return kInversePairsHelper(n, k, mem);
    }
  

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
		for (int i = 0; i <= Math.min(k, n - 1); i++) {
			mem[n][k] += kInversePairs(n - 1, k - i);
		}
		return mem[n][k];
	}
}
