/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC151ReverseWordsinaString {

	 public String preprocess(String s)
	    {
     char [] a = s.toCharArray();
     int n = s.length();
	        int i = 0, j = 0;
   
   while (j < n) {

       while (j < n && a[j] == ' ') j++;             // skip spaces
       while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
       while (j < n && a[j] == ' ') j++;             // skip spaces
       if (j < n) a[i++] = ' ';                      // keep only one space
 }

 return new String(a).substring(0, i);
}
	    
 public String reverseWords(String s) {
     
     
     s = preprocess(s);
     System.out.println(s);
     char [] inp = s.toCharArray();
     reverse(inp,0, s.length()-1);
     
     int i =0;
     int j = 0;
     while(j < s.length())
     {
         if(inp[j] == ' ')
         {
             reverse(inp, i, j-1);
              i = j+1;
              j=i;
         }else{
             j++;
         }
        
     }
     
     reverse(inp, i, j-1);
     return String.valueOf(inp);
     
 }
 
public void reverse(char [] inp, int start, int end)
 {
     while(start<end)
     {
         char temp = inp[start];
         inp[start] = inp[end];
         inp[end]=temp;
         start++;
         end --;
     }
 }
	   
	   public static void main(String[] args) {
		   LC151ReverseWordsinaString lc = new LC151ReverseWordsinaString();
		System.out.println(lc.reverseWords("a"));
		
	}
}
