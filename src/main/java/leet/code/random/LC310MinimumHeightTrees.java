/**
 * 
 */
package leet.code.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author manu
 *
 */
public class LC310MinimumHeightTrees {

	class Node {
		int val;
		ArrayList<Integer> path;
		int pathLen;

		Node(int x, int len) {
			val = x;
			pathLen = len;
			path = new ArrayList<Integer>();
		}
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {

		List<Integer> out = new ArrayList<Integer>();
		// int [] [] graph = new int [n][n];
		List<List<Integer>> lgraph = new ArrayList<List<Integer>>();

		for (int i = 0; i < n; i++) {
			lgraph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < edges.length; i++) {
			int left = edges[i][0];
			int right = edges[i][1];
			// graph[left][right] = 1;
			// graph[right][left] = 1;
			lgraph.get(left).add(right);
			lgraph.get(right).add(left);
		}

		Node random_x = new Node(0, 0);
		Node longest_y = BFS(lgraph, random_x, n);
		longest_y.path = new ArrayList<Integer>();
		longest_y.pathLen = 0;
		Node longest_z = BFS(lgraph, longest_y, n);

		return longest_z.path.size() % 2 == 0
				? new ArrayList<Integer>(Arrays.asList(longest_z.path.get(longest_z.path.size() / 2),
						longest_z.path.get((longest_z.path.size() / 2) - 1)))
				: new ArrayList<Integer>(Arrays.asList(longest_z.path.get(longest_z.path.size() / 2)));

	}

	public Node BFS(List<List<Integer>> graph, Node x, int n) {
		Queue<Node> q = new LinkedList<Node>();
		int max = -1;
		Node maxNode = x;
		x.path.add(x.val);
		q.add(x);
		// q.add(null);
		boolean visited[] = new boolean[n];
		visited[x.val] = true;

		while (!q.isEmpty()) {
			Node v = q.poll();
			if (v.pathLen > max) {
				max = v.pathLen;
				maxNode = v;
			}

			for (Integer e : graph.get(v.val)) {
				if (!visited[e]) {
					visited[e] = true;
					Node e2Add = new Node(e, v.pathLen + 1);
					e2Add.path = new ArrayList<Integer>(v.path);
					e2Add.path.add(e2Add.val);
					q.add(e2Add);
				}
			}
		}
		// System.out.println(maxNode.val+ " path "+ maxNode.path);
		return maxNode;
	}
}
