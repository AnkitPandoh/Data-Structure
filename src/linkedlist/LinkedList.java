package linkedlist;

import java.util.Scanner;

public class LinkedList {
	private int size;
	private Node head;
	private Node tail;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList ls = new LinkedList();
		for (int i = 0; i < 5; i++) {
			ls.add(scan.nextInt());
		}
		System.out.println("Before Removing..");
		Node node = ls.head;
		while (node != null) {
			System.out.print(node.value + "-->");
			node = node.next;
		}

		ls.remove(5);
		ls.remove(1);
		System.out.println();
		System.out.println("After Removing..");
		node = ls.head;
		while (node != null) {
			System.out.print(node.value + "-->");
			node = node.next;
		}
		System.out.println("size:" + ls.size);
	}

	private Node create(int value) {
		return new Node(value, null);
	}

	public void add(int value) {
		Node n = create(value);
		if (size == 0) {
			head = n;
			tail = n;
			n.next = null;
		} else {
			tail.next = n;
			tail = n;
		}
		++size;
	}

	public void remove(int pos) {
		if (pos > size) {
			System.out.println("Sorry, not a valid position..");
			return;
		}
		if (size == 0) {
			System.out.println("List is empty..");
			return;
		}
		if (pos == 1) {
			head = head.next;
			--size;
			return;
		}
		Node n = head;
		for (int i = 1; i < pos; i++) {
			if (i == pos - 1) {
				n.next = n.next.next;
				--size;
			} else {
				n = n.next;
			}
		}
		return;
	}

	private static class Node {
		private int value;
		private Node next;

		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
}
