/**
 * 
 */
package ctci.chap3;

/**
 * @author manu
 *
 */
public class StackUtils {

	public static boolean equals(Stack st1, Stack st2) throws Exception {
		while (!st1.isEmpty()) {
			if (st1.pop() != st2.pop())
				return false;
		}
		if (!st2.isEmpty())
			return false;

		return true;
	}

	public static int getLength(Stack<Integer> st1) throws Exception {
		Stack<Integer> temp = new Stack<Integer>();
		int length = 0;
		while (!st1.isEmpty()) {
			temp.push(st1.pop());
			length++;
		}
		while (!temp.isEmpty()) {
			st1.push(temp.pop());
		}
		return length;
	}

	public static void printStack(Stack<Integer> stack) throws Exception {
		Stack<Integer> temp = new Stack<Integer>();
		while (!stack.isEmpty()) {
			temp.push(stack.pop());
		}
		while (!temp.isEmpty()) {
			System.out.print(temp.pop() + "-->");
		}
		System.out.println();

	}

	public static Stack revereStack(Stack<Integer> s1) throws Exception {
		Stack<Integer> temp = new Stack<Integer>();
		while (!s1.isEmpty()) {
			temp.push(s1.pop());

		}
		return temp;
	}

}
