/**
 * 
 */
package leet.code.random;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author manu
 *
 */
public class LongestRepeatingCharacterReplacement424 {

	// public int characterReplacement(String s, int k) {
	//
	// int[] freq = new int[26];
	// int max = 0;
	// int n = s.length();
	// for (int i = 0; i < s.length(); i++) {
	// freq[s.charAt(i) - 'A']++;
	// }
	// for (int i = 0; i < 26; i++) {
	//
	// if (freq[i] > 0) {
	// char replace = (char)(i+'A');
	// int rem = k;
	// Queue<Integer> index= new LinkedList<Integer>();
	// Queue<Integer> lengthAtReplace= new LinkedList<Integer>();
	// int last = 0;
	// // lengthAtReplace.add(0);
	// int length = 0;
	// int j = 0;
	// while(j<n && rem>0)
	// {
	// if(s.charAt(j)!=replace)
	// {
	// rem--;
	// lengthAtReplace.add(length+1-last);
	// last =length+1-last;
	// //index.add(j);
	// }
	// length++;
	// j++;
	// }
	//
	// while(j<n && s.charAt(j)==replace){
	// length++;
	// j++;
	// }
	//
	// if(length>max)
	// {
	// max = length;
	// }
	//
	// while(j<n)
	// {
	// if(lengthAtReplace.size()>0)
	// {
	// length = length - lengthAtReplace.poll()+1;
	// last =length-last;
	// lengthAtReplace.add(last);
	// j++;
	// }else{
	// length=0;
	// j++;
	// }
	//
	// while(j<n && s.charAt(j)==replace)
	// {
	// length++;
	// j++;
	// }
	//
	//
	// if(length>max)
	// {
	// max = length;
	// }
	//
	// }
	// if(length>max)
	// {
	// max = length;
	// }
	//
	// }
	// }
	// return max;
	// }

	public int characterReplacement(String s, int k) {

		int[] freq = new int[26];
		int start = 0, end = 0, n = s.length(), maxLen = 0, maxFreq = 0;

		while (end < n) {
			maxFreq = Math.max(maxFreq, ++freq[s.charAt(end) - 'A']);
			while (maxFreq + k < end - start + 1) {
				--freq[s.charAt(start) - 'A'];
				start++;
			}
			if (end - start + 1 > maxLen) {
				maxLen = end - start + 1;
			}
			end++;
		}

		return maxLen;
	}

	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement424 test = new LongestRepeatingCharacterReplacement424();
		System.out.println(test.characterReplacement(
				"KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF",
				4));
		System.out.println(test.characterReplacement(
				"EOEMQLLQTRQDDCOERARHGAAARRBKCCMFTDAQOLOKARBIJBISTGNKBQGKKTALSQNFSABASNOPBMMGDIOETPTDICRBOMBAAHINTFLH",
				7));
		System.out.println(test.characterReplacement("AABBABBA", 2));
		System.out.println(test.characterReplacement("ABBB", 2));
	}

}
