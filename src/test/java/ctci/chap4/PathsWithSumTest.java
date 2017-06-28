package ctci.chap4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ctci.chap4.Tree.TreeNode;
import junit.framework.Assert;

public class PathsWithSumTest {

	public PathsWithSum handler;
	public Tree tree;
	public TreeNode root;
	public TreeNode node1;
	public TreeNode node2;
	public TreeNode node3;
	public TreeNode node4;
	public TreeNode node5;
	public TreeNode node6;
	public TreeNode node7;
	public TreeNode node8;

	@Before
	public void setUp() throws Exception {
		handler = new PathsWithSum();
		tree = new Tree(root);
		tree.root = tree.new TreeNode(10);
		node1 = tree.new TreeNode(5);
		node2 = tree.new TreeNode(-3);
		node3 = tree.new TreeNode(11);
		node4 = tree.new TreeNode(2);
		node5 = tree.new TreeNode(1);
		node6 = tree.new TreeNode(3);
		node7 = tree.new TreeNode(3);
		node8 = tree.new TreeNode(-2);

		tree.root.right = node2;
		tree.root.right.right = node3;
		tree.root.left = node1;
		tree.root.left.left = node4;
		tree.root.left.left = node5;
		tree.root.left.left = node6;
		tree.root.left.left.left = node7;
		tree.root.left.left.right = node8;
	}

	@Test
	public void test() {
		Assert.assertEquals(2, handler.getPaths(tree.root, 8));
		Assert.assertEquals(2, handler.getPathRunTimeOptimised(tree.root, 8));

	}

}
