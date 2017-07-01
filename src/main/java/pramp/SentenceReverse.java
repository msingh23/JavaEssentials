/**
 * 
 */
package pramp;

import java.util.ArrayList;
import java.util.Stack;

public class SentenceReverse {

	static char[] reverseWords(char[] arr) {
		// your code goes here

		ArrayList<Character> out = new ArrayList<Character>();
		Stack<ArrayList<Character>> parsed = parse(arr, ' ');
		while (!parsed.isEmpty()) {
			ArrayList<Character> arr1 = parsed.pop();
			for (Character ch : arr1) {
				out.add(ch);

			}
			out.add(' ');
		}
		// 'a', 'c', 't', 'i', 'c', 'e',' ','m', 'a', 'k', 'e', 's',
		// p', 'e', 'r', 'f', 'e', 'c', 't,' '
		out.remove(out.size() - 1);

		return out.toString().toCharArray();

	}

	private static Stack<ArrayList<Character>> parse(char[] inp, char delim) {

		ArrayList<Character> temp = new ArrayList<Character>();
		Stack<ArrayList<Character>> st = new Stack<ArrayList<Character>>();
		for (int i = 0; i < inp.length; i++) {

			if (inp[i] != delim) {
				temp.add(inp[i]);
			} else if (inp[i] == delim) {
				st.push(temp); // <'p', 'e', 'r', 'f', 'e', 'c', 't'>,<'m', 'a',
								// 'k', 'e', 's'>,<p', 'r', 'a', 'c', 't', 'i',
								// 'c', 'e'>
				// printArray(temp.toString().toCharArray());
				temp = new ArrayList<Character>();
			}

		}
		st.push(temp);
		return st;

	}

	public static void printArray(char[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

	public char[] SentenceReverse(char[] inp) {

		int start = 0;
		int end = inp.length;
		reverse(inp, start, end - 1);
		for (int i = 0; i < inp.length; i++) {
			if (inp[i] == ' ') {
				reverse(inp, start, i - 1);
				start = i + 1;
			}
		}
		reverse(inp, start, end - 1);

		return inp;

	}

	private void reverse(char[] inp, int start, int end) {
		while (start < end) {
			char temp = inp[start];
			inp[start] = inp[end];
			inp[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {

		
		char[] arr = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't',
				'i', 'c', 'e' };
		printArray(arr);
		new SentenceReverse().SentenceReverse(arr);

		printArray(arr);

	}

}
