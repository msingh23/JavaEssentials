/**
 * 
 */
package ctci.chap4;

import java.util.ArrayList;

import ctci.chap4.Graph.GraphNode;

/**
 * @author manu
 *
 */
public class RouteBetweenNodes {

	public boolean isRouteExist(GraphNode n1, GraphNode n2) {
		return (findPath(n1, n2) || findPath(n2, n1));

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
