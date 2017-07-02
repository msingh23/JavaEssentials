/**
 * 
 */
package pramp;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * @author manu
 *
 */
public class FlattenDictionaryTest {

	/**
	 * @throws java.lang.Exception
	 */
	public FlattenDictionary handler;
	Map<String, Object> inp;
	Map<String, String> out;

	@Before
	public void setUp() throws Exception {
		handler = new FlattenDictionary();
		inp = new HashMap<String, Object>();
		inp.put("Key1", "1");
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("d", "3");
		mp.put("e", "1");
		Map<String, Object> mp2 = new HashMap<String, Object>();
		mp2.put("a", "2");
		mp2.put("b", "3");
		mp2.put("c", mp);
		inp.put("Key2", mp2);

	}

	@Test
	public void test() {
		System.out.println(handler.flattenDictionary(inp));
	}

}
