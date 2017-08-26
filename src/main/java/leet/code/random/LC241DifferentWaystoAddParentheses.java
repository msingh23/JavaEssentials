/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC241DifferentWaystoAddParentheses {

	Map<String, List<Integer>> mp = new HashMap<String, List<Integer>>();

	public List<Integer> diffWaysToCompute(String input) {

		List<Integer> out = new ArrayList<Integer>();
		if (mp.get(input) != null) {
			// out.add(mp.get(input));
			return mp.get(input);
		}
		for (int i = 0; i < input.length(); i++) {
			int curr = input.charAt(i);
			if (curr == '*' || curr == '-' || curr == '+') {
				String left = input.substring(0, i);
				String right = input.substring(i + 1);

				List<Integer> leftList = diffWaysToCompute(left);
				List<Integer> rightList = diffWaysToCompute(right);

				for (Integer leftL : leftList) {
					for (Integer rightL : rightList) {
						switch (curr) {
						case '*':
							out.add(leftL * rightL);
							mp.put(input, out);
							break;
						case '-':
							out.add(leftL - rightL);
							mp.put(input, out);
							break;
						case '+':
							out.add(leftL + rightL);
							mp.put(input, out);
							break;
						}

					}
				}

			}
		}

		if (out.size() == 0) {

			out.add(Integer.valueOf(input));
			if (mp.get(input) == null) {
				mp.put(input, out);
			}
		}
		return out;
	}

	public static void main(String[] args) {
		System.out.println(new LC241DifferentWaystoAddParentheses().diffWaysToCompute("2*3-4*5"));
	}
}
