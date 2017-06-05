package test;

import ctci.chap2.Node;

public class Junk2 {

	public static void main(String[] args) {

		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);

		System.out.println(i1 == i2);
		System.out.println(i1.equals(i2));
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = n1;
		System.out.println(n1 == n2);
		System.out.println(n1.equals(n2));
	}
}
