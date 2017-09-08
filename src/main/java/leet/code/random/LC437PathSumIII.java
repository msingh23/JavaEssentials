package leet.code.random;

import java.util.HashMap;
import java.util.Map;

public class LC437PathSumIII {

	int count = 0;
	Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

	public int pathSum(TreeNode root, int sum) {
		mp.put(0, 1);
		pathSum(root, 0, sum);
		return count;
	}

	public void pathSum(TreeNode root, int curr, int sum) {

		if (null == root)
			return;

		curr += root.val;
		count += mp.getOrDefault(curr - sum, 0);
		mp.put(curr, mp.getOrDefault(curr, 0) + 1);

		pathSum(root.left, curr, sum);
		pathSum(root.right, curr, sum);

		mp.put(curr, mp.get(curr) - 1);

	}
}
