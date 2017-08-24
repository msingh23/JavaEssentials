package leet.code.random;

import java.util.ArrayList;
import java.util.Arrays;

public class LC395LongestSubstring {
    
    
/*
aaeebzbccdd

aaabzbzbccc
     *       *
a:2, b:2, c:2 , e:2, z:1 , d:2


*/

    /*
    Brute force
    */
   
    public int longestSubstringHelper(String s, int start, int end, int k )
    {
        if(start<=end)
        {
             int freq [] = new int [26];
    
             for(int i = start; i<= end ; i++)
             {
                freq[s.charAt(i)-'a']+=1;
             }
            boolean flag = false;
            for(int i = 0 ; i < 26; i++)
            {
                if(freq[i]<k && freq[i]>0){
                    flag = true;
                    break;
                }
            }
           if(flag) return Math.max(longestSubstringHelper(s, start, end-1, k), longestSubstringHelper(s, start+1, end, k) ) ;
            else return end-start+1;
            
        }
        
        return 0;
    }
    
    /*
    
    aaaabccbcc
    */
    
    /*
    //Throwing stackoverflow
    
    public int longestSubstring(String s, int k) {
        int left = 0;
        int right = s.length();
       
        if(k==0 || right<k)
        {
         return 0;    
        }   
        
        int [] freq = getFrequency(s);
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(freq[s.charAt(i)-'a']>0 && freq[s.charAt(i)-'a']<k)
            {
                 left = longestSubstring(s.substring(0,i),k);
                 right = longestSubstring(s.substring(i+1,s.length()),k);
               // break;
                return Math.max(left, right);
            }
        }
      return s.length();
    }

*/
    
     public int longestSubstring(String s, int k) {
        int max = 0;
        if(k==0) return k;
        String splitter = getInvalidChar(s,k);
        if(splitter==""){
            return s.length();
        }else{
            String [] splits = s.split(splitter);
            for(int i = 0 ; i < splits.length; i ++)
            {
                int len = longestSubstring(splits[i], k);
                if(max<len){
                    max= len;
                }
            }   
            return max;
        }
         //return s.length();
    }
   
    
    public int [] getFrequency(String str)
    {
        int freq [] = new int [26];
        
        for(int i = 0 ; i < str.length(); i++)
        {
            freq[str.charAt(i)- 'a']+=1;
            
        }
        return freq;
    }
    public boolean isValid(String str, int k )
    {
        int freq [] = getFrequency(str);    
        
        for(int i = 0 ; i < 26; i++)
        {
            if(freq[i]>0 && freq[i]<k)
            {
                return false;
            }
        }
        return true;
    }
    
     public String getInvalidChar(String str, int k )
    {
        int freq [] = getFrequency(str);    
        
        for(int i = 0 ; i < 26; i++)
        {
            if(freq[i]>0 && freq[i]<k)
            {
                return String.valueOf((char)(i+'a'));
            }
        }
        return "";
    }
}