/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC167TwoSumIIInputarrayissorted {

	public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length -1;
        
        while(start<end)
        {
            int sum = numbers[start] + numbers[end];
            if(sum == target) break;
            else if(sum>target) end --;
            else start++;
        }
        return new int []{start+1, end+1};
    }
}
