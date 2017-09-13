/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC367ValidPerfectSquare {

	 public boolean isPerfectSquare(int num) 
	    {
	        if(num == 1) return true;
	        return isPerfectSquare( num, 1, num);
	    }
	    
	    public boolean  isPerfectSquare( int num, int start, int end)
	    {
	       
	        if(start<=end)
	        {
	            int sqrt = start + (end-start)/2;
	            System.out.println(sqrt);
	            if((double)sqrt == (double)num/sqrt) return true;
	            else if(sqrt > num/sqrt ) return isPerfectSquare(num, start, sqrt-1);
	            else if(sqrt +1 > num/(sqrt+1) ) return false; 
	             else   
	                return isPerfectSquare(num, sqrt+1, end);
	        }
	        return false;
	    }
	
}
