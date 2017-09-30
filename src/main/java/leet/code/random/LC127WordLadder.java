/**
 * 
 */
package leet.code.random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author manu
 *
 */
public class LC127WordLadder {

	 /*
    DFS
   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean > include = new HashMap<String, Boolean>();
        for(String word : wordList) include.put(word, false);
        include.put(beginWord, true);
        int ans = ladderLengthHelp(beginWord, endWord, wordList, include);
        if(ans==Integer.MAX_VALUE-1) return 0;
        return ans+1;
    }
    
    public int ladderLengthHelp(String b, String e, List<String> list, Map<String, Boolean > include )
    {
        int min = Integer.MAX_VALUE-1;
        //int count = diff(b, e);
        
        if(b.equals(e))
        {
        	//System.out.println(buff);
            return 0;
        }
        
        for(String w : list)
        {
            if(include.get(w)) continue;
            
            int cw = diff(b, w);
            if(cw<2)
            {
                include.put(w, true);
                int mw  = cw + ladderLengthHelp(w, e, list, include);
                //System.out.println(b +" "+ w);
                if(mw<min)
                {
                    min = mw;
                }
                include.put(w, false);
            }
        }
        return min;
    }
    
    public int diff(String s1, String s2)
    {
        int i = 0;
        int count = 0;
        while(i<s1.length())
        {
            if(s1.charAt(i)!=s2.charAt(i++))
            {
                 if(count ==1) return 2;
                count++;
             }
        }
        
        return count;
    }
    */
    
    /*
    BFS   
    */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<String>();
        for(String word : wordList) set.add(word);
        
        Queue<Object[]> q = new LinkedList<Object[]>();
        q.add(new Object[]{beginWord, 1});
        
        while(!q.isEmpty() && !set.isEmpty())
        {
            Object [] obj = q.poll();
            String currWord = (String) obj[0];
            Integer ladder = (Integer) obj[1];
            
            char [] word = currWord.toCharArray();
           // System.out.println(new String( word)) ;
            for(int i = 0; i < word.length; i++)
            {
                for(char ch = 'a'; ch<='z' ;ch++)
                {
                    if(word[i]!=ch)
                    {
                        char temp = word[i];
                        word[i] = ch;
                        String newWord = new String(word);
                        if(set.contains(newWord))
                        {
                            if(newWord.equals(endWord))
                            {
                                return ladder + 1;
                            }
                            
                            q.add(new Object[]{newWord, ladder + 1});
                            set.remove(newWord);
                        }
                         word[i] = temp;
                    }
                }
            }
            
            
        }
        return 0;
    }
    
    public static void main(String[] args) {
		LC127WordLadder lc = new LC127WordLadder();
		System.out.println(lc.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
		//System.out.println(lc.ladderLength("qa", "sq", (List<String>) Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));
	}
	
	
}
