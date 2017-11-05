/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC306AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for(int i = 1; i <=n/2 ; i++)
        {
              if(num.charAt(0) == '0' && i>1) return false;
            for(int j = i+1; j<=(n-Math.max(i, j-i)); j++)
            {
                if(num.charAt(i) == '0' && j-i >1) break;
                long n1 = Long.valueOf(num.substring(0,i));
                long n2 = Long.valueOf(num.substring(i, j) );
                
                if(isAdditive(n1, n2, num.substring(j))) return true;
            }
        }
            
        return false;
    }
    
    public boolean isAdditive(long  n1, long n2, String num)
    {
        System.out.println(n1+ " "+ n2 + " " + num);
        if(num.length() == 0) return true;
        String sum = String.valueOf(n1+n2);
        if(!num.startsWith(sum)) return false;
        return isAdditive(n2, n1+n2, num.substring(sum.length()));
    }
}
