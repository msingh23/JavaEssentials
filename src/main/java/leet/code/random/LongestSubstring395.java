package leet.code.random;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestSubstring395 {
    
/*
aaeebzbccdd

aaabzbzbccc
     *       *
a:2, b:2, c:2 , e:2, z:1 , d:2


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
    
    public int longestSubstring(String s, int k) {
        int max = 0;
        if(k==0) return k;
        
        if(isValid(s,k)){
            return s.length();
        }else{
            ArrayList<String> sub = split(s,k);
            for(String st : sub){
                int len = longestSubstring(st, k);
                if(max<len){
                    max= len;
                }
            }
            return max;
        }
        
     
        
        //return longestSubstringHelper(s, 0 , s.length()-1 , k)       
        
    }
    public ArrayList<String> split(String str, int k)
    {
       int freq [] =  getFrequency(str);
        
        ArrayList<String> out = new ArrayList<String>();
        out.add(str);
        
        for(int i = 0 ; i < freq.length; i++){
            ArrayList<String> temp = new ArrayList<String>(); 
            if(freq[i]>0 && freq[i]<k)
            {
                for(String sub : out)
                {
                	String splitter = String.valueOf((char)(i+'a'));
                    String subs[] = sub.split(String.valueOf((char)(i+'a')));
                    temp.addAll(Arrays.asList(subs));
                    
                }
                out = new ArrayList<String>(temp);
            }
        }
        return out;
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
}