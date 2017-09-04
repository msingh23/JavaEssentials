/**
 * 
 */
package leet.code.random;

/**
 * @author manu
 *
 */
public class LC4MedianofTwoSortedArrays {

	public double findMedianSortedArrays(int A[], int B[]) {

		int m = A.length;
		int n = B.length;

		if (m > n)
			return findMedianSortedArrays(B, A);

		int imax = m;
		int imin = 0;

		while (imin <= imax) {
			int i = imin + (imax - imin) / 2;
			int j = (m + n + 1) / 2 - i;

			if (i > 0 && A[i - 1] > B[j]) {
				imax = i - 1;
			} else if (i < m && B[j - 1] > A[i]) {
				imin = i + 1;
			} else {

				double max_left = 0;
				
				if (i == 0)
					max_left = (double) B[j - 1];
				else if (j == 0)
					max_left = (double) A[i - 1];
				else
					max_left = Math.max(A[i - 1], B[j - 1]);

				if ((m + n) % 2 != 0)
					return max_left;
				
				double min_right = 0;
				if (i == m)
					min_right = (double)  B[j];
				else if (j == n)
					min_right =  (double) A[i];
				else
					min_right = ((double)  Math.min(A[i], B[j])) ;

				return (max_left +min_right) / 2.0;
			}

		}
		return 0.0;
	}

	public static void main(String[] args) {
		LC4MedianofTwoSortedArrays LC = new LC4MedianofTwoSortedArrays();
		System.out.println(LC.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
	}
}
