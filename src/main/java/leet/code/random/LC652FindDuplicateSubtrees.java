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
public class LC652FindDuplicateSubtrees {

	List<TreeNode> out = new ArrayList<TreeNode>();

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

		Map<String, TreeNode> map = new HashMap<String, TreeNode>();
		findDuplicateSubtreesHelp(root, map);
		return out;
	}

	public String findDuplicateSubtreesHelp(TreeNode root, Map<String, TreeNode> map) {
		if (root == null)
			return new String("#");
		String left = findDuplicateSubtreesHelp(root.left, map);
		String right = findDuplicateSubtreesHelp(root.right, map);

		String key = left + right + String.valueOf(root.val);

		if (map.containsKey(key)) {
			if (map.get(key) == null) {
				// System.out.println(key);
				out.add(root);
				map.put(key, root);
			}

		} else {
			// System.out.println(key);
			map.put(key, null);
		}

		return key;

	}
}
