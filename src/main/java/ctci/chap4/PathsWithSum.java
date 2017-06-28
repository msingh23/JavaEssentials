/**
 * 
 */
package ctci.chap4;

import java.util.HashMap;

import ctci.chap4.Tree.TreeNode;

/**
 * @author manu
 *
 */
public class PathsWithSum {

	public class Ans {
		int count = 0;
	}

	public int getPathRunTimeOptimised(TreeNode node, int sum) {
		if (node == null) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		return getAllSumPaths(node, sum, 0, map);
	}

	private int getAllSumPaths(TreeNode node, int sum, int runningSum, HashMap<Integer, Integer> map) {
		if (node == null) {
			return 0;
		}
		int currSum = runningSum + node.data;
		int currPath = map.getOrDefault(currSum - sum, 0);
		if (currSum == sum) {
			currPath++;
		}
		updateMap(map, currSum, 1);
		int leftPath = getAllSumPaths(node.left, sum, currPath, map);
		int rightPath = getAllSumPaths(node.right, sum, currPath, map);
		updateMap(map, currPath, -1);
		return currPath + leftPath + rightPath;
	}

	private void updateMap(HashMap<Integer, Integer> map, int runningSum, int i) {
		int count = map.getOrDefault(runningSum, 0);
		count += i;
		if (count == 0) {
			map.remove(runningSum);
		} else if (count > 0) {
			map.put(runningSum, count);
		}
	}

	public int getPaths(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}

		int rootPaths = countPaths(root, sum, 0);
		int leftPath = getPaths(root.left, sum);
		int rightPath = getPaths(root.right, sum);
		return rootPaths + leftPath + rightPath;

	}

	private int countPaths(TreeNode root, int sum, int currSum) {
		if (root == null) {
			return 0;
		}

		if (sum == currSum + root.data) {
			return 1;
		}
		int left = countPaths(root.left, sum, currSum + root.data);
		int right = countPaths(root.right, sum, currSum + root.data);

		return left + right;

	}

}
