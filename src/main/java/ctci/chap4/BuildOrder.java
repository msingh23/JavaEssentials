/**
 * 
 */
package ctci.chap4;

import java.util.ArrayList;

import ctci.chap3.Stack;
import ctci.chap4.Graph.GraphNode;

/**
 * @author manu
 *
 */
public class BuildOrder {

	public Character[] getOrder(Character[] projects, Character[][] dependency) throws Exception {

		Graph graph = buildGraph(projects, dependency);
		Character[] out = new Character[graph.list.size()];
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < graph.list.size(); i++) {
			GraphNode node = (GraphNode) graph.list.get(i);
			if (!node.visit) {
				sort(node, st);
			}
		}

		for (int i = 0; i < graph.list.size(); i++) {
			out[i] = st.pop();
		}

		return out;

	}

	private void sort(GraphNode node, Stack<Character> st) {

		node.visit = true;
		for (GraphNode child : (ArrayList<GraphNode>) node.nodes) {
			if (!child.visit) {
				sort(child, st);

			}
		}
		st.push((Character) node.data);

	}

	private Graph buildGraph(Character[] projects, Character[][] dependency) {

		Graph graph = new Graph<Character>();

		for (int i = 0; i < projects.length; i++) {
			graph.addVertex(graph.new GraphNode(projects[i]).data);
		}

		for (int i = 0; i < dependency.length; i++) {
			graph.addEdge((GraphNode) graph.map.get(dependency[i][0]), (GraphNode) graph.map.get(dependency[i][1]));
		}

		return graph;
	}

}
