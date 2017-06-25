package ctci.chap4;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BuildOrderTest {

	public BuildOrder handler;
	Character[] projects;
	Character[][] dependency;

	@Before
	public void setUp() throws Exception {
		handler = new BuildOrder();
		projects = new Character[] { 'a', 'b', 'c', 'd', 'e', 'f' };
		dependency = new Character[][] { { 'a', 'd' }, { 'f', 'b' }, { 'b', 'd' }, { 'f', 'a' }, { 'd', 'c' } };
	}

	@Test
	public void test() throws Exception {
		System.out.println();
		for (Character ch : handler.getOrder(projects, dependency)) {
			System.out.print(ch + ", ");
		}
	}

}
