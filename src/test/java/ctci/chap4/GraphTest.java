package ctci.chap4;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ctci.chap4.Graph.GraphNode;

public class GraphTest {

	public Graph<Integer> handler;
	public ArrayList<Integer> out;

	@Before
	public void setUp() throws Exception {
		handler = new Graph<Integer>(1);
		out = new ArrayList<Integer>();
		GraphNode n2 = handler.new GraphNode(2);
		GraphNode n3 = handler.new GraphNode(3);
		GraphNode n4 = handler.new GraphNode(4);
		GraphNode n5 = handler.new GraphNode(5);
		GraphNode n6 = handler.new GraphNode(6);

		handler.root.addNode(n2);
		handler.root.addNode(n3);
		handler.root.addNode(n4);
		n2.addNode(n3);
		n2.addNode(n5);
		n2.addNode(handler.root);
		n3.addNode(handler.root);
		n3.addNode(n2);
		n3.addNode(n6);
		n5.addNode(n2);
		n5.addNode(n6);
		n6.addNode(n3);
		n6.addNode(n5);
		n6.addNode(n4);
		n4.addNode(n6);
		n4.addNode(handler.root);

	}

//	@Test
//	public void testDFS() {
//		handler.DFS(handler.root, out);
//
//	}
//	
	@Test
	public void testBFS() throws Exception {
		handler.BFS();

	}

}
