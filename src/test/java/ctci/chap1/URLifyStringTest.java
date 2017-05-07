package ctci.chap1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class URLifyStringTest {

	private String[][] inp;
	private String[][] out;

	private URLifyString handler;

	@Before
	public void setUp() throws Exception {
		handler = new URLifyString();
		inp = new String[][] { { "abc d e f                 " }, { "null                     " }, { "Mr John Smith                  " } };
		out = new String[][] { { "abc%20d%20e%20f" }, { "null" }, { "Mr%20John%20Smith" } };

	}

	@Test
	public void test() {
		for (int i = 0; i < inp.length; i++) {
			// char[] proc = new char[out[i][0].length()];
			// for (int j = 0; j < proc.length; j++) {
			// if (j < inp[i][0].length()) {
			// proc[j] = inp[i][0].charAt(j);
			// } else {
			// proc[j] = ' ';
			// }
			// }

			//System.out.println(handler.replaceInString(inp[i][0].toCharArray(), inp[i][0].trim().length()));
			//System.out.println(out[i][0]);
			Assert.assertArrayEquals(handler.replaceInString(inp[i][0].toCharArray(), inp[i][0].trim().length()),
					out[i][0].toCharArray());

		}

	}

}
