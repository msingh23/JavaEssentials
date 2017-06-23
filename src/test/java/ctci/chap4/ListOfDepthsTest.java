/**
 * 
 */
package ctci.chap4;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ctci.chap4.BinaryTree.TreeNode;

/**
 * @author manu
 *
 */
public class ListOfDepthsTest {

	/**
	 * @throws java.lang.Exception
	 */
	public ListOfDepths handler;
	public BinaryTree tree;
	public ArrayList<ArrayList<TreeNode>> listOfList;
	public ArrayList<TreeNode> list;

	@Before
	public void setUp() throws Exception {
		handler = new ListOfDepths();
		listOfList = new ArrayList<ArrayList<TreeNode>>();
		list = new ArrayList<TreeNode>();
		tree = new BinaryTree(5);
		tree.add(tree.root, 3);
		tree.add(tree.root, 8);
		tree.add(tree.root, 2);
		tree.add(tree.root, 4);
		tree.add(tree.root, 1);

	}

	@Test
	public void test() throws Exception {
		//tree.InOrderTraversal(tree.root);
		handler.createListOfDepths(tree, listOfList, list);
		for (ArrayList<TreeNode> list : listOfList) {
			for (TreeNode node : list) {
				System.out.print(node.value + ", ");
			}
			System.out.println();
		}
		// System.out.println(listOfList);
	}

}
