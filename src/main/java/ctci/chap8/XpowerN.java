package ctci.chap8;

public class XpowerN {

	public int power(int x , int n)
	{
		if(n ==0)
		{
			return 1;
		}
		if(n == 1)
		{
			return x;
		}
		
		int halfPower = n >>1;
		int half = power(x, halfPower);
		
		if(n % 2 ==1)
		{
			return half * half * x;
		}
		return half * half;
	}
	
}
