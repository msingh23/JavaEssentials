/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC186ReverseWordsinaStringII {

	 public void reverseWords(char[] s) {
	        swap(s, 0, s.length-1);
	       
	        int start = -1;
	        for(int i = 0; i<s.length; i++)
	        {
	            if(s[i] == ' ' )
	            {
	                swap(s, start+1, i-1);
	                start=i;
	            }
	            if(i == s.length-1)
	                swap(s, start+1, i);
	        }
	        
	    }
	    
	    public void swap(char [] in, int start, int end)
	    {
	        while(start<end)
	        {
	            char temp = in[start];
	            in[start] = in[end];
	            in[end] = temp;
	            start++;
	            end--;
	        }
	    }
}
