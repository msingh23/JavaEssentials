/**
 * 
 */
package ctci.chap8;

/**
 * @author manu
 *
 */
public class TripleStep {
	
	
	/*
	 *  if n = 3
	 *  [1,1,1], [1,2], [2,1], [3]
	 *  
	 *  if n=4
	 *  [1,1,1,1], [1,1,2], [1,2,1], [1,3], [2,1,1], [2,2] , [3,1]
	 *  
	 *  if n = 5
	 *  [1,1,1,1,1], 
	 *  [1,1,1,2] 
	 *  [1,1,2,1]
	 *  [1,2,1,1]
	 *  [1,2,2]
	 *  [2,1,1,1]
	 *  [2,1,2]
	 *  [2,2,1]
	 *  [2,3]
	 *  [3,1,1]
	 *  [3,2]
	 * 
	 */
	
	public int getStepWays(int n )
	{
		int total = 0;
		StringBuffer buff = new StringBuffer();
		return getStepWaysHelper( 0, n , total, buff);
	}

	private int getStepWaysHelper(int curr, int n, int total, StringBuffer buff) 
	{
		if(curr>n)
		{
			//buff.delete(buff.length()-2, buff.length());
			return 0;
		}
		if(curr==n)
		{
			//System.out.println(buff.toString());
			//buff.delete(buff.length()-2, buff.length());
			return 1;
		}
		
		for(int i = 1 ; i<4 ; i++)
		{
			buff.append(i+",");
			total += getStepWaysHelper(curr+i, n , 0, buff);
			buff.delete(buff.length()-2, buff.length());
		}
		return total;
		
		
	}

}
