package ctci.chap4;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import ctci.chap4.BinaryTree.TreeNode;

public class AllArrayFromTreeTest {

	public AllArrayFromTree handler;
	public BinaryTree tree;
	public BinaryTree tree1;

	@Before
	public void setUp() throws Exception {
		handler = new AllArrayFromTree();
		tree = new BinaryTree(5);
		tree.add(tree.root, 3);
		tree.add(tree.root, 8);
		tree.add(tree.root, 9);
		tree.add(tree.root, 7);
		tree.add(tree.root, 2);
		tree.add(tree.root, 4);
		//tree.add(tree.root, 1);

		tree1 = new BinaryTree(2);
		tree1.add(tree1.root, 3);
		tree1.add(tree1.root, 1);

	}

	@Test
	public void test() {
		ArrayList<LinkedList<TreeNode>> list = handler.getNode(tree.root);
		for (LinkedList<TreeNode> l : list) {

			for (TreeNode node : l) {
				System.out.print(node.value + ", ");
			}
			System.out.println();
		}
	}

}
