package ctci.chap5;

public class PairwiseSwap {
	
	public int pairWiseSwap(int inp)
	{
		int i = 0;
		int no = inp;
		int prev = 0;
		int curr = 0;
		int out = 0;
		while(no > 0 && i < 32)
		{
			prev = no & 1;
			no = no >>1;
			curr = no & 1;
			out = out | (curr << i++);
			out = out | (prev << i++);
			curr = 0;
			prev = 0;
			no = no >>1;
		}
		return out;
	}

}
