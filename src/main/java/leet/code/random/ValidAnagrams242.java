/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class ValidAnagrams242 {

	
	public boolean isAnagram(String s, String t) {
        int [] freq  = new int [26];
        return updateFreq(s,freq, +1) || updateFreq(t,freq, -1);
        
        // int bitVector = 0;
        // bitVector = parseStringAndSetBit(s,bitVector );
        // bitVector = parseStringAndSetBit(t,bitVector );
        // return bitVector==0? true:false;
        
    }
    private boolean updateFreq(String str, int [] freq, int updateVal)
    {
        for(int i = 0 ; i <str.length(); i++)
        {
            int charKey = str.charAt(i) - 'a';
            freq[charKey]+=updateVal;
            if(freq[charKey]<0)
            {
                return false;
            }
        }
        for(int i = 0 ; i <26; i++)
        {
            if(freq[i]>0 || freq[i]<0)
            {
                return false;
            }
        }
        return true;
    }
    
//     private int parseStringAndSetBit(String str, int bitVec)
//     {
//         for(int i = 0 ; i <str.length(); i++)
//         {
//             int flipBit = str.charAt(i)-'a';
//             int mask = 1<<flipBit;
//             if( (bitVec & mask) ==0)
//             {
//                 bitVec|=mask;
//             }else
//             {
                
//             }
//         }
//     }
}
