/**
 * 
 */
package leet.code.random;

import java.util.Stack;

/**
 * @author manu
 *
 */
public class LC316RemoveDuplicateLetters {

	/*
	 * brute force
	 */
	/*
	 * brute force
	 */
	// public String removeDuplicateLetters(String s) {
	//
	// int freq [] = new int [26];
	// int n = s.length(), uniq=0;
	// String min = s+s;
	//
	// for(int i = 0; i<n; i++)
	// {
	// if(freq[s.charAt(i)-'a']==0)
	// {
	// uniq++;
	// }
	// freq[s.charAt(i)-'a']=1;
	// }
	//
	//
	// for(int i =0 ; i<n; i++ )
	// {
	// freq = new int [26];
	// int uniqSub=0;
	// StringBuffer ans= new StringBuffer();
	// for(int j = i; j<n; j++)
	// {
	// if(freq[s.charAt(j)-'a']==0)
	// {
	// uniqSub++;
	// ans.append(s.charAt(j));
	// freq[s.charAt(j)-'a'] =1;
	// }
	// if(uniqSub==uniq)
	// {
	// if(ans.toString().compareTo(min)<0 || ans.length()<min.length())
	// {
	// min=ans.toString();
	// }
	// break;
	// }
	//
	//
	// }
	// }
	// return min;
	//
	// }

	/*
	 * brute force 2^n n!
	
	public String removeDuplicateLetters(String s) {

		int freq[] = new int[26];
		int n = s.length(), uniq = 0;
		String min = s + s;

		for (int i = 0; i < n; i++) {
			if (freq[s.charAt(i) - 'a'] == 0) {
				uniq++;
			}
			freq[s.charAt(i) - 'a'] = 1;
		}
		StringBuffer ans = new StringBuffer();
		return removeDuplicateLetters(s, uniq, ans, 0, 0, new int[26], min);
	}

	public String removeDuplicateLetters(String s, int uniq, StringBuffer ans, int ind, int uniqSub, int[] freq,
			String min) {
		int n = s.length();

		if (uniqSub == uniq) {
			if (ans.toString().compareTo(min) < 0 || ans.length() < min.length()) {

				min = ans.toString();
				System.out.println(min);
			}
			return min;
		}

		String left = min;
		String right = min;

		for (int j = ind; j < n; j++) {
			if (freq[s.charAt(j) - 'a'] == 0) {
				uniqSub++;
				ans.append(s.charAt(j));
				freq[s.charAt(j) - 'a'] = 1;
				left = removeDuplicateLetters(s, uniq, ans, j + 1, uniqSub, freq, min);
				uniqSub--;
				ans.deleteCharAt(ans.length() - 1);
				freq[s.charAt(j) - 'a'] = 0;
				right = removeDuplicateLetters(s, uniq, ans, j + 1, uniqSub, freq, min);
				if (left.compareTo(right) < 0 || left.length()<right.length()) {
					min = left;
				} else {
					min = right;
				}
			}

		}

		return min;
	}
	 */
	 public String removeDuplicateLetters(String s) 
	    {
	        int n = s.length();
	        int [] freq = new int [26];
	        boolean [] include = new boolean [26];
	        Stack<Character> st = new Stack<Character>();
	        
	        for(int i = 0; i <n ; i++)
	        {
	            freq[s.charAt(i)-'a']++;
	        }
	        
	        for(int i=0 ; i<n ; i++)
	        {
	            char ch = s.charAt(i);
	            if(include[ch-'a']) 
             {
                 freq[ch-'a']--;
                 continue;
             }
               
	            
	            while(!st.isEmpty() && st.peek()>ch && freq[st.peek()-'a']>0)
	            {
	                
	                //freq[st.peek()-'a']--;
	                include[st.peek()-'a']=false;
	                st.pop();
	            }
	            st.push(ch);
	            freq[ch-'a']--;
	            include[ch-'a']=true;
	        }
	        StringBuffer buff = new StringBuffer();
	        while(!st.isEmpty())
	        {
	            buff.insert(0,st.pop());
	        }
	        return buff.toString();
	    }
	public static void main(String[] args) {
		System.out.println(new LC316RemoveDuplicateLetters().removeDuplicateLetters("bbcaaeae"));
	}

}
