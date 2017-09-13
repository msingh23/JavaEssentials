/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC372SuperPow {

	/*
	 * 
	 * This is failing for some test cases
	 * 
	 */
	 int mod = 1337;
	    public int superPow(int a, int[] b) {
	        
	        int ans =1;
	        int n = b.length;
	        //a= a%mod;
	        for(int i = n-1 ;i >=0 ; i--)
	        {
	            /*
	              391
	              3-0        3-2
	              300 + 90 + 1
	              */
	            //int position = (int)Math.pow(10 , (n-i-1 ));
	            ans = (ans * powByMod(a, b[i] , mod)) % mod ;
	            a = powByMod(a, 10, mod);
	        }
	        return ans;
	    }
	    
	    public int powByMod(int x, int n , int mod)
	    {
	       // System.out.println(n);
	        if(x==1 || n==0) return 1;
	        if(n==1) return x;
	        
	        int pow = powByMod(x, n/2, mod) % mod;
	        return (n % 2 == 0)?  (pow * pow) % mod  : ((x % mod) * pow * pow) % mod;
	    }
}
