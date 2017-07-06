package ctci.exta;

public class Fibonacci {

	/*
	 * generate n fibonaci numbers n= 5 0, 1, 1 , 2, 3,
	 * 
	 * n =10 0 1, 1, 2, 3, 5, 8, 13, 21, 34
	 * 
	 */

	public static void printFibonacci(int no) {

		int prev = 1;
		int prevPrev = 0;
		int curr = 0;
		while (curr < no) {
			System.out.print(prevPrev + " ");
			int temp = prevPrev;
			prevPrev = prev;
			prev = temp + prev;
			curr++;
		}

		// while(no > 2 && curr< no)
		// {
		//
		// }
		//

	}

	public static int getFibonacciRecursive(int n) {

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		return getFibonacciRecursive(n - 1) + getFibonacciRecursive(n - 2);
	}

	public static int getFibonacciRecursiveMemoization(int n) {
		return fibonacciMemozation(n, new int[n + 1]);
	}

	private static int fibonacciMemozation(int n, int[] mem) {

		if (n == 0 || n == 1)
			return n;

		if (mem[n] == 0) {
			mem[n] = fibonacciMemozation(n - 1, mem) + fibonacciMemozation(n - 2, mem);
		}

		return mem[n];
	}
	
	private static int getFibonacci(int n )
	{
		
		int a = 0;
		int b = 1;
		int c = 0;
		for(int i = 1 ; i <= n ; i ++ )
		{
			c = a +b;
			a = b;
			b = c;
		}
		return c;
	}

	public static void main(String[] args) {

		printFibonacci(10);
		System.out.println();
		System.out.println(getFibonacciRecursive(10));
		System.out.println(getFibonacciRecursiveMemoization(10));
		System.out.println(getFibonacciRecursive(10));
	}

}
