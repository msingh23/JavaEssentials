/**
 * 
 */
package ctci.chap5;

/**
 * @author manu
 *
 */
public class FlipBit {

	public int getLongestSequence(int no) {
		int max = 0;
		int consOnes = 0;
		int curr = 0;
		boolean flip = false;
		int mask = 1;
		int prevBit = -1;
		int currBit = -1;

		while (no > 0) {

			currBit = no & mask;

			if (currBit == 1) {
				consOnes++;
				curr++;
			} else if (currBit == 0) {
				if (!flip) {
					flip = true;
					curr = consOnes;
					curr++;
					consOnes = 0;
				} else {
					if (prevBit == 0) {
						consOnes = 0;
					}
					curr = 1;
					curr = curr + consOnes;
				}
			}
			prevBit = currBit;
			if (curr > max) {
				max = curr;
			}

			no = no >> 1;
		}
		/*if (!flip) {
			if (consOnes > max) {
				max = consOnes;
			}
		}*/

		return max;
	}

}
