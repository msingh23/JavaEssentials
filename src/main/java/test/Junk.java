/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
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
		
		
		LinkedList<Integer> set1 = new LinkedList<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		//System.out.println(set1.get(2));
		System.out.println(set1.remove(2));
		System.out.println(set1.remove(2));
		System.out.println(set1.remove(1));
		System.out.println(set1.remove(0));
		long l = 1000000000000000000l;
		System.out.println(Math.pow(l,1.0/2));
		System.out.println(Math.log(l)/Math.log(2));
	//	System.out.println(log(1, 1));
		
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(3, 34);
		
		int a =  'a';
		char b = '0';
		
		System.out.println(a);
		System.out.println(Integer.valueOf(b));
	}
	
	 
   
}
