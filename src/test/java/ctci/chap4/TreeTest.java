package ctci.chap4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ctci.chap4.BinaryTree.TreeNode;

public class TreeTest {

	public BinaryTree handler;
	public BinaryTree handler2;

	@Before
	public void setUp() throws Exception {
		handler = new BinaryTree(10);
		handler.add(handler.root, 4);
		handler.add(handler.root, 8);
		handler.add(handler.root, 7);
		handler.add(handler.root, 6);
		handler.add(handler.root, 5);
		handler.add(handler.root, 9);
		
		handler2 = new BinaryTree(10);
		handler2.add2(handler2.root, 4);
		handler2.add2(handler2.root, 8);
		handler2.add2(handler2.root, 7);
		handler2.add2(handler2.root, 6);
		handler2.add2(handler2.root, 5);
		handler2.add2(handler2.root, 9);
	}

	@Test
	public void test() {
		handler.InOrderTraversal(handler.root);
		System.out.println();
		handler2.InOrderTraversal(handler2.root);
		System.out.println();
		System.out.println();
		handler.PreOrderTraversal(handler.root);
		System.out.println();
		handler2.PreOrderTraversal(handler2.root);
		System.out.println();
		System.out.println();
		handler.PostOrderTraversal(handler.root);
		System.out.println();
		handler2.PostOrderTraversal(handler2.root);
		
		
	}

}
