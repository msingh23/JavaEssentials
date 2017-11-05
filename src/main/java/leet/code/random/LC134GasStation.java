/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC134GasStation {

	/*
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int capacity = 0;
        while(start < gas.length)
        {
            capacity = 0;
            for(int i = start ;i < gas.length ;i ++)
            {
                if(capacity<0 ) break;
                capacity = capacity + gas[i] - cost[i];
                
            }
            for(int i = 0 ;i <=start;i++)
            {
                
                if(capacity<0) break;
                if(i==start) return start;
                capacity = capacity + gas[i] - cost[i];
            }
            
            start++;
        }
        return -1;
    }
    */
    
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int total = 0, curr = 0, start =0 ; 
        for(int i = 0; i<gas.length ; i++)
        {
            
            curr  = curr + gas[i] - cost[i];
            if(curr<0)
            {
                start = i+1;
                total +=curr;
                curr=0;
            }
            
        }
        return total+curr < 0 ? -1 : start;
    }
}
