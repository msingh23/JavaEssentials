/**
 * 
 */
package ctci.chap4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ctci.chap3.Queue;

/**
 * @author manu
 *
 */
public class Graph<T> {

	GraphNode<T> root;
	List<GraphNode<T>> list;
	Map<T, GraphNode> map = new HashMap<T, GraphNode>();

	public class GraphNode<T> {
		T data;
		List<GraphNode<T>> nodes;
		boolean visit;

		public GraphNode(T data) {
			this.data = data;
			nodes = new ArrayList<GraphNode<T>>();
			visit = false;
		}

		public void addNode(T data) {
			GraphNode<T> node = new GraphNode<T>(data);
			this.nodes.add(node);
			// list.add(node);
			// node.nodes.add(this);
		}

		public void addNode(GraphNode<T> node) {
			this.nodes.add(node);
			// list.add(node);
			// node.nodes.add(this);
		}

	}

	public void addEdge(GraphNode a, GraphNode b) {
		a.nodes.add(b);

	}

	public Graph() {
		list = new ArrayList<GraphNode<T>>();
	}

	public Graph(T data) {
		list = new ArrayList<GraphNode<T>>();
		root = new GraphNode(data);
	}

	public void addVertex(T data) {
		GraphNode node = new GraphNode<T>(data);
		list.add(node);
		map.put(data, node);
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
