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

public String reverseWords2(String s) {
    
    if(null == s || s.length() == 0) return s;
    
    String is = s.trim();
    if(is.length() == 0) return is;
    char [] arr = is.toCharArray();
   
    int end = getEnd(arr);
    
    swap(arr, 0, end);
   
    int start = -1;
    for(int i = 0; i<=end; i++)
    {
        if(arr[i] == ' ' )
        {
            swap(arr, start+1, i-1);
            start=i;
        }
        if(i == end)
            swap(arr, start+1, i);
    }
    
    String out = new String(arr);
    return out.trim();
    
}
public int getEnd(char [] in)
{
    int start = 0;
    int end = 0;
    while(end<in.length)
    {
        if(in[end] == ' ')
        {
            in[start++] = in[end++];
            while(end<in.length && in[end] == ' ')
            {
                end++;
            }
        }
        else
            in[start++] = in[end++];
    }
    end = start-1;
    while(start<in.length)
    {
        in[start++] = ' ';
    }
    return end;
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
	   public static void main(String[] args) {
		   LC151ReverseWordsinaString lc = new LC151ReverseWordsinaString();
		System.out.println(lc.reverseWords("a"));
		
	}
}
