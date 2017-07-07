package ctci.chap8;

public class MagicIndex {
	
	
	/*
	 * 
	 * 1,3,4,5,6,7,7,7,7
	 * 0 1 2 3 4 5 6 7 8
	 * 
	 */
	
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
	
	public int getIndexNonUnique(int [] inp)
	{
		return getIndexNonUnique(inp, 0, inp.length -1);
	}

	private int getIndexNonUnique(int[] inp, int start, int end) {

		if(start<=end)
		{
			int mid = start + (end-start) / 2;
			if(inp[mid] == mid)
			{
				return mid;
			}
			
			/*
			 * search left of mid but search only from indexed start to min(inp[mid], mid-1)
			 */
			
			int newEnd = Math.min(mid -1, inp[mid]);
			int left = getIndexNonUnique(inp, start, newEnd);
			
			
			
			/*
			 * search right of mid but search only from index max(inp[mid], mid+1) to end
			 */
			int newstart=-1;
			int right = -1;
			if(left==-1)
			{
				newstart = Math.max(mid+1, inp[mid]);
				right = getIndexNonUnique(inp, newstart, end);
			}else{
				return left;
			}
			
			return right;
		}
		
		return -1;
	}

}
