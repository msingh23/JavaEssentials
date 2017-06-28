/**
 * 
 */
package ctci.chap4;

import java.util.Random;

import ctci.chap3.Queue;

/**
 * @author manu
 *
 */
public class TreeRandom {

	public TreeRandomNode root;

	public class TreeRandomNode {
		public TreeRandomNode(int data2) {
			this.data = data2;
			size = 1;
		}

		int data;
		int size;
		TreeRandomNode left;
		TreeRandomNode right;

	}

	public void printDataAndSize() throws Exception {
		Queue<TreeRandomNode> q = new Queue<TreeRandomNode>();
		q.enqueue(this.root);
		while (!q.isEmpty()) {
			TreeRandomNode temp = q.dequeue();
			System.out.print(temp.data + " , " + temp.size + "	");
			if (temp.left != null) {
				q.enqueue(temp.left);
			}
			if (temp.right != null) {
				q.enqueue(temp.right);
			}
		}
	}

	public TreeRandomNode random() {
		Random rand = new Random();
		int ran = rand.nextInt( this.root.size);
		// ran++;
		System.out.print("ran no :: " + ran);
		return getIth(this.root, ran);
	}

	private TreeRandomNode getIth(TreeRandomNode root, int ran) {
		int left = (root == null || (root.left == null)) ? 0 : root.left.size;
		if (ran < left) {
			return getIth(root.left, ran);
		}
		 if (ran == left) {
			return root;
		}
		 if (ran > left) {
			return getIth(root.right, root.size - (ran+1));
		}
		return null;
	}

	public TreeRandomNode find(TreeRandomNode root, int data) {

		if (root == null) {
			return null;
		}

		if (root.data == data) {
			return root;
		}
		else if (data < root.data) {
			return find(root.left, data);
		}
		else if (data > root.data) {
			return find(root.right, data);
		}

		return null;
	}

	public void insert(int data) {
		this.root = insert(this.root, data);
	}

	public TreeRandomNode insert(TreeRandomNode root, int data) {

		if (root == null) {
			TreeRandomNode temp = new TreeRandomNode(data);
			root = temp;
			return root;
		} else if (data <= root.data) {
			root.left = insert(root.left, data);
			root.size++;
		} else if (data > root.data) {
			root.right = insert(root.right, data);
			root.size++;
		}
		return root;
	}

}
