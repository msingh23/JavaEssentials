package ctci.chap5;

public class Conversion {

	public int getDifferenceOfBits(int x , int y)
	{
		
		int xor = x ^ y;
		int count =0;
		while(xor >0)
		{
			if((xor & 1)==1){
				count++;
			}
			xor>>>=1;
		}
		
		return count;
	}
	
}
