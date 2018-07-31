package linkedlist;
/**
 * Merging two sorted LinkedList in sorted order without using 
 * extra space.
 * https://www.youtube.com/watch?v=j_UNYW6Ap0k
 * 
 *
 */
public class MergeSortedLinkedList {
	public static void main(String[] args) {
		LinkList<Integer> l1 = new LinkList<>();
		l1.add(1);
		l1.add(3);
		l1.add(9);
		l1.add(11);

		LinkList<Integer> l2 = new LinkList<>();
		l2.add(4);
		l2.add(5);
		l2.add(10);
		MergeSortedLinkedList sort = new MergeSortedLinkedList();
		Node start = sort.merge(l1.head, l2.head);
		while (start != null) {
			System.out.print(start.value + " ");
			start = start.next;
		}
	}

	public Node merge(Node l1, Node l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		Node mergeNode = null;
		Node tempNode = null;
		if (l1 != null && l2 != null) {
			if (l1.value < l2.value) {
				tempNode = l1;
				l1 = tempNode.next;
			} else {
				tempNode = l2;
				l2 = tempNode.next;
			}
			mergeNode = tempNode;
		}
		while (l1 != null && l2 != null) {
			if (l1.value < l2.value) {
				tempNode.next = l1;
				tempNode = l1;
				l1 = tempNode.next;
			} else {
				tempNode.next = l2;
				tempNode = l2;
				l2 = tempNode.next;
			}
		}
		if (l1 == null) {
			tempNode.next = l2;
		} else if (l2 == null) {
			tempNode.next = l1;
		}
		return mergeNode;
	}

	static class LinkList<E> {
		private int size;
		private Node head;
		private Node tail;

		public void add(int value) {
			Node n = new Node(value);
			n.next = null;
			if (head == null) {
				head = n;
				tail = n;
			} else {
				tail.next = n;
				tail = n;
			}
			size++;
		}
	}
}

class Node {
	int value;
	Node next;

	Node(int value) {
		this.value = value;
	}
}
