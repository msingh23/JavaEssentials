/**
 * 
 */
package ctci.chap3;

/**
 * @author manu
 *
 */
public class ThreeStack {

	int head1, size1 = 0;
	int head2, size2 = 0;
	int head3, size3 = 0;
	int val[];

	public ThreeStack(int length) {
		val = new int[length];
		head1 = 0;
		head3 = length - 1;
		head2 = length / 2;
	}

	public void push(int stackNo, int data) throws Exception {
		if (isStackFull()) {
			throw new Exception("Stack is full");
		}
		switch (stackNo) {
		case (0): {
			if (head1 + size1 == head2) {
				moveRight();
			}
			val[head1 + size1] = data;
			size1++;
			break;

		}
		case (1): {
			if (head2 + size2 == head3 - size3) {
				moveLeft();
			}
			val[head2 + size2] = data;
			size2++;
			break;
		}
		case (2): {
			if (head2 + size2 == head3 - size3) {
				moveLeft();
			}
			val[head3 - size3] = data;
			size3++;
			break;
		}

		}
	}

	public int peek(int stackNo) {
		switch (stackNo) {
		case (0): {
			return val[head1 + size1 - 1];
		}
		case (1): {
			return val[head2 + size2 - 1];
		}
		case (2): {
			return val[head3 - size3 + 1];
		}
		}

		return 0;
	}

	public int pop(int stackNo) throws Exception {
		int out = 0;
		switch (stackNo) {
		case (0): {
			if (size1 == 0) {
				throw new Exception("stack is empty");
			}
			out = val[head1 + size1 - 1];
			size1--;
			break;
		}
		case (1): {
			if (size2 == 0) {
				throw new Exception("stack is empty");
			}
			out = val[head2 + size2 - 1];
			size2--;
			break;
		}
		case (2): {
			if (size3 == 0) {
				throw new Exception("stack is empty");
			}
			out = val[head3 - size3 + 1];
			size3--;
			break;
		}
		}

		return out;
	}

	private boolean isStackFull() {
		return (size1 + size2 + size3) == val.length;
	}

	private void moveLeft() {
		// TODO Auto-generated method stub
		boolean move = false;
		for (int i = head2; i < head2 + size2; i++) {
			val[i - 1] = val[i];
			move = true;
		}
		if (move)
			head2--;
	}

	private void moveRight() {
		// TODO Auto-generated method stub
		boolean move = false;
		int end = head2 + size2 - 1;
		for (int i = end; i >= head2; i--) {
			val[i] = val[i + 1];
			move = true;
		}
		if (move)
			head2++;

	}
}
