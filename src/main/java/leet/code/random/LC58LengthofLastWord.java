/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC58LengthofLastWord {

	public int lengthOfLastWord(String s) {
        s= s.trim();
        int len = 0;
        int index = s.length()-1;
        while( index>= 0 && s.charAt(index--)!=' ') len++;
        
        //if(index<0) return 0;
        return len;
        
        
    }
	
	
}
