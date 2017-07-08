package ctci.chap8;

public class RecursiveMultiply {

	public int multiply(int a, int b) {
		int big = a > b ? a : b;
		int small = b < a ? b : a;

		return multiplyHelper(big, small);
	}

	private int multiplyHelper(int big, int small) {

		if (small == 0) {
			return 0;
		}
		if (small == 1) {
			return big;
		}
		int half = small >> 1; // divide by 2
		int halfPart = multiplyHelper(big, half);
		int otherHalf = halfPart;
		if (small % 2 == 1) {
			otherHalf = multiplyHelper(big, small - half);
		}
		return halfPart + otherHalf;
	}

	public int multiplyMemoization(int a, int b) {
		int big = a > b ? a : b;
		int small = b < a ? b : a;
		int[] mem = new int[small + 1];
		return multiplyMemoizationHelper(big, small, mem);
	}

	private int multiplyMemoizationHelper(int big, int small, int[] mem) {
		if (small == 0) {
			mem[small] = 0;
			return 0;
		}
		if (small == 1) {
			mem[small] = big;
			return big;
		}
		if(mem[small]>0){
			return mem[small];
		}
		
		int half = small>>1;
		int sum1 = multiplyMemoizationHelper(big, half, mem);
		int sum2 = sum1;
		if(small%2==1){
			sum2 = multiplyMemoizationHelper(big, small-half, mem);
		}
		mem[small] = sum1+sum2;
		return mem[small];
		

		
	}
}
