/**
 * 
 */
package leet.code.random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author manu
 *
 */
public class LC208ImplementTriePrefixTree {
	class Trie {

		Character val;
		Map<Character, Trie> map;

		public Trie(Character ch) {
			map = new HashMap<Character, Trie>();
			val = ch;
		}

		/** Initialize your data structure here. */
		public Trie() {
			map = new HashMap<Character, Trie>();
			val = '*';
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			Map<Character, Trie> map = this.map;
			for (Character ch : word.toCharArray()) {
				Trie exist = map.getOrDefault(ch, null);
				if (null == exist) {
					exist = new Trie(ch);
					map.put(ch, exist);
				}
				map = exist.map;
			}
			map.put('*', new Trie('*'));
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {

			Map<Character, Trie> map = this.map;
			for (Character ch : word.toCharArray()) {
				Trie exist = map.getOrDefault(ch, null);
				if (null == exist) {
					return false;
				}
				map = exist.map;
			}

			if (map.get('*') != null)
				return true;
			return false;
		}

		/**
		 * Returns if there is any word in the trie that starts with the given
		 * prefix.
		 */
		public boolean startsWith(String prefix) {
			Map<Character, Trie> map = this.map;
			for (Character ch : prefix.toCharArray()) {
				Trie exist = map.getOrDefault(ch, null);
				if (null == exist) {
					return false;
				}
				map = exist.map;
			}

			return true;
		}
	}

	/**
	 * Your Trie object will be instantiated and called as such: Trie obj = new
	 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean
	 * param_3 = obj.startsWith(prefix);
	 */
	
	public static void main(String[] args) {
		LC208ImplementTriePrefixTree lc = new LC208ImplementTriePrefixTree();
		Trie t = lc.new Trie();
		t.insert("ab");
		System.out.println(t.search("a"));
		System.out.println(t.startsWith("a"));
	}
}
