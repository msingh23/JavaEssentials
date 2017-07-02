/**
 * 
 */
package pramp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author manu
 *
 */
public class FlattenDictionary {

	public Map<String, String> flattenDictionary(Map<String, Object> dic) {

		Map<String, String> out = new HashMap<String, String>();
		if (dic != null) {
			flattenDictionaryHelper(dic, out, new StringBuffer());
		}

		return out;

	}

	private void flattenDictionaryHelper(Map<String, Object> dic, Map<String, String> out, StringBuffer prefix) {
		Set<String> keySet = dic.keySet();
		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			if (dic.get(key) instanceof String) {
				prefix.append(key);
				out.put(prefix.toString(), (String) dic.get(key));
				prefix.delete(prefix.length() - key.length(), prefix.length());
			} else if (dic.get(key) instanceof Object) {
				prefix.append(key);
				flattenDictionaryHelper((Map<String, Object>) dic.get(key), out, prefix.append('.'));
				prefix.deleteCharAt(prefix.length() - 1);
				prefix.delete(prefix.length() - key.length(), prefix.length());
			}

		}

	}

}
