package pramp;

import java.io.*;
import java.util.*;

class BracketMatch {

	/*
	 * 
	 * finalCount = 0 currCount =
	 * 
	 * 
	 */

	// static int bracketMatch

	public int bracketMatch(String text) {

		int finalCounter = 0;
		int currCounter = 0;

		for (int i = 0; i < text.length(); i++) {

			char ch = text.charAt(i);

			if (ch == '(') {

				if (currCounter >= 0) {
					currCounter++;
				} else {
					finalCounter += currCounter;
					currCounter = 1;
				}

			} else if (ch == ')') {
				currCounter--;
			}

		}

		return Math.abs(finalCounter) + Math.abs(currCounter);

	}

	public int bracketMatchStack(String text) {
		Stack<Character> st = new Stack<Character>();

		int correction = 0;
		for (int i = 0; i < text.length(); i++) {

			Character ch = text.charAt(i);

			if (ch == '(') {
				st.push(ch);
			} else if (ch == ')') {
				if (!st.isEmpty()) {

					Character top = st.peek();
					if (top == '(') {
						st.pop();
					} else {
						st.push('(');
					}
				} else {
					correction++;
				}
			}

		}
		return correction + st.size();

	}

}
