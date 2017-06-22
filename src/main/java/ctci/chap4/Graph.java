/**
 * 
 */
package ctci.chap4;

import java.util.ArrayList;
import java.util.List;

import ctci.chap3.Queue;

/**
 * @author manu
 *
 */
public class Graph<T> {

	GraphNode<T> root;

	public class GraphNode<T> {
		T data;
		List<GraphNode> nodes;
		boolean visit;

		public GraphNode(T data) {
			this.data = data;
			nodes = new ArrayList<GraphNode>();
			visit = false;
		}

		public void addNode(T data) {
			GraphNode<T> node = new GraphNode(data);
			this.nodes.add(node);
			node.nodes.add(this);
		}

		public void addNode(GraphNode<T> node) {
			this.nodes.add(node);
			// node.nodes.add(this);
		}

	}

	public Graph(T data) {
		root = new GraphNode(data);
	}

	public void DFS(GraphNode<T> root, ArrayList<T> out) {
		if (root != null) {
			if (!root.visit) {
				out.add(root.data);
				System.out.println(root.data);
				root.visit = true;
				for (GraphNode node : root.nodes) {
					DFS(node, out);
				}

			}
		}
	}

	public void BFS() throws Exception {
		Queue<GraphNode<T>> queue = new Queue<GraphNode<T>>();
		queue.enqueue(this.root);
		this.root.visit = true;

		while (!queue.isEmpty()) {
			GraphNode<T> prev = queue.dequeue();
			System.out.println(prev.data);
			for (GraphNode node : prev.nodes) {
				if (!node.visit) {
					queue.enqueue(node);
					node.visit = true;
				}
			}

		}
	}

}
