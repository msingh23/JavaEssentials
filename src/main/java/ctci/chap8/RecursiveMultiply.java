package ctci.chap8;

public class RecursiveMultiply {
	
	public int multiply(int a , int b)
	{
		int big = a>b ? a : b;
		int small = b<a ? b : a;
		
		return multiplyHelper(big, small);
	}

	private int multiplyHelper(int big, int small) {
		
		if(small == 0){
			return 0;
		}
		if(small == 1){
			return big;
		}
		int half = small>>1; //divide by 2
		int halfPart = multiplyHelper(big , half);
		int otherHalf = halfPart;
		if(small%2 ==1)
		{
			otherHalf = multiplyHelper(big, small - half);
		}
		return halfPart + otherHalf;
	}

}
