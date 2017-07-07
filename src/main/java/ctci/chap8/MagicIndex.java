package ctci.chap8;

public class MagicIndex {
	
	
	public int getIndex(int [] inp)
	{
		int start = 0 ; 
		int end = inp.length -1;
		
		while(start<=end)
		{
			int mid = start + (end-start)/2;
			
			if(inp[mid] == mid)
			{
				return mid;
			}
			if(inp[mid] >mid)
			{
				end = mid -1;
			}else
			{
				start = mid + 1;
			}
					
		}
		return -1;
	}

}
