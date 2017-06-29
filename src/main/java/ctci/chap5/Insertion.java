package ctci.chap5;

public class Insertion {

	public int insertion(int n, int m, int j, int i) {

		int allOnes = -1;

		int left = allOnes << (j + 1);
		int right = (1 << i) - 1;

		int mask = left | right;
		int nWithzero = n & mask;
		int mShifted = m << i;

		return nWithzero | mShifted;

	}

}
