package ctci.chap4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ctci.chap4.Tree.TreeNode;
import junit.framework.Assert;

public class LeastCommonAncestorTest {

	public LeastCommonAncestor handler;
	public Tree tree;
	public TreeNode root;
	public TreeNode node1;
	public TreeNode node2;
	public TreeNode node3;
	public TreeNode node4;
	public TreeNode node5;
	public TreeNode node6;
	public TreeNode node7;

	@Before
	public void setUp() throws Exception {
		handler = new LeastCommonAncestor();
		tree = new Tree(root);
		tree.root = tree.new TreeNode(20);
		node1 = tree.new TreeNode(10);
		node2 = tree.new TreeNode(30);
		node3 = tree.new TreeNode(5);
		node4 = tree.new TreeNode(15);
		node5 = tree.new TreeNode(17);
		node6 = tree.new TreeNode(7);
		node7 = tree.new TreeNode(3);
		//tree = new Tree(root);
		tree.root.addLeftNode(node1);
		tree.root.addRightNode(node2);
		tree.root.left.addLeftNode(node3);
		tree.root.left.addRightNode(node4);
		tree.root.left.right.addRightNode(node5);
		tree.root.left.left.addRightNode(node6);
		tree.root.left.left.addLeftNode(node7);
	}

	@Test
	public void testLCAParent() {
		Assert.assertEquals(node1, handler.LCAWithParent(tree.root, node3, node5));
		Assert.assertEquals(node1, handler.LCAWithParent(tree.root, node7, node5));
		Assert.assertEquals(tree.root, handler.LCAWithParent(tree.root, node2, node7));
		Assert.assertEquals(tree.root, handler.LCAWithParent(tree.root, tree.root, node7));
		
	}

}
