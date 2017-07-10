/**
 * 
 */
package test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author manu
 *
 */
public class Junk {

	public static void main(String[] args) {

		int vec = 0;

		vec = 1 << -1;

		System.out.println(vec);
		System.out.println((2147483647 + 1));

		Set<Integer> set = new HashSet<Integer>();
		int[] in = new int[] { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };

		for (int i = 0; i < in.length; i++) {
			set.add(in[i]);
		}
		
		System.out.println(1<<0);
		
		
		String s = "aaabbbcdefcdefgggggggggggggggcde";
		String [] arr= (s.trim().split("f"));
		for(int i = 0 ; i< arr.length; i++){
			System.out.println(arr[i]);
		}
		

	}

}
