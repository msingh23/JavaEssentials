package ctci.chap4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ctci.chap4.Graph.GraphNode;
import junit.framework.Assert;

public class RouteBetweenNodesTest {

	public RouteBetweenNodes handler;
	public Graph<Integer> graph;
	GraphNode n2;
	GraphNode n3;
	GraphNode n4;
	GraphNode n5;
	GraphNode n6;

	@Before
	public void setUp() throws Exception {
		handler = new RouteBetweenNodes();
		graph = new Graph<Integer>(1);
		n2 = graph.new GraphNode(2);
		n3 = graph.new GraphNode(3);
		n4 = graph.new GraphNode(4);
		n5 = graph.new GraphNode(5);
		n6 = graph.new GraphNode(6);
		graph.root.addNode(n2);
		n2.addNode(n3);
		n3.addNode(n4);
		n4.addNode(n5);
		n4.addNode(graph.root);
		n6.addNode(n5);
	}

	@Test
	public void testCyclicExist() {
		Assert.assertEquals(handler.isRouteExist(n2, graph.root), true);
	}

	@Test
	public void testPathDoesntExist() {
		Assert.assertEquals(handler.isRouteExist(n2, n6), false);
	}

	@Test
	public void testPathExistReverse() {
		Assert.assertEquals(handler.isRouteExist(n3, n2), true);
	}

}
