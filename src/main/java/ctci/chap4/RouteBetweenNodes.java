/**
 * 
 */
package ctci.chap4;

import java.util.ArrayList;

import ctci.chap3.Queue;
import ctci.chap4.Graph.GraphNode;

/**
 * @author manu
 *
 */
public class RouteBetweenNodes {

	public boolean isRouteExist(GraphNode n1, GraphNode n2) {
		return (findPath(n1, n2) || findPath(n2, n1));

	}

	public boolean isRouteExistBFS(GraphNode n1, GraphNode n2) throws Exception {
		return (findPathisRouteExistBFS(n1, n2) || findPathisRouteExistBFS(n2, n1));

	}

	private boolean findPathisRouteExistBFS(GraphNode n1, GraphNode n2) throws Exception {

		if (n1 != null && n2 != null) {
			Queue<GraphNode> q = new Queue<GraphNode>();
			q.enqueue(n1);
			n1.visit = true;
			while (!q.isEmpty()) {
				GraphNode temp = q.dequeue();
				if (temp == n2) {
					return true;
				}

				for (GraphNode node : (ArrayList<GraphNode>) temp.nodes) {
					if (!node.visit) {
						q.enqueue(node);
						node.visit = true;
					}

				}
			}
		}
		return false;
	}

	private boolean findPath(GraphNode n1, GraphNode n2) {
		if (n1 != null) {
			if (n1 == n2)
				return true;
			if (!n1.visit) {
				n1.visit = true;
				for (GraphNode node : (ArrayList<GraphNode>) n1.nodes) {
					if (!node.visit) {
						if (findPath(node, n2)) {
							return true;
						}

					}
				}
			}
		}

		return false;
	}

}
