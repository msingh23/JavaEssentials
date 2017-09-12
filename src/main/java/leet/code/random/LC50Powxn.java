/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC50Powxn {

    /*
    public double myPow(double x, int n) {
        if(x==1) return x;
        if(n == Integer.MIN_VALUE) {
            n = Integer.MAX_VALUE;
            return myPow(1/x, n) * 1/x;
        }
        if(n<0)  return myPow(1/x, Math.abs(n));
        if(n==0) return 1.0;
        if(n==1) return x;
        
        int q = n/2;
        int r = n%2;
        double child = myPow(x, q);
        double rem = myPow(x, r);
        
        return child * child * rem;
        
    }
    */
    
    double myPow(double x, int n) { 
    if(n==0) return 1;
    double t = myPow(x,n/2);
    if(n%2!=0) return n<0 ? 1/x*t*t : x*t*t;
    else return t*t;
}
}
