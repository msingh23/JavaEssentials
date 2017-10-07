/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author manu
 *
 */
public class LC119PascalsTriangleII {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> curr = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; i++) {
			curr.add(0, 1);
			for (int j = 1; j < i; j++) {
				curr.set(j, curr.get(j) + curr.get(j + 1));
			}
		}
		return curr;
	}
}
