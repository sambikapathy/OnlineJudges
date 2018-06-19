package careercup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class reversell {
	public static void main(String[] args) throws java.lang.Exception {
		LinkedList a = new LinkedList();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the no. of nodes");
		int n = in.nextInt();
		System.out.println("Enter the elements in the linked list");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();

		char[] ch = line.toCharArray();
		for (int i = 0; i < n; i++) {
			a.add(ch[i]);
		}
		System.out.print("Original Link List 1 : ");
		a.display(a.head);
		a.reverse(a.head);
		a.palindrome();
	}
}

class Node1 {
	public char data;
	public Node1 next;

	public Node1(char d) {
		data = d;
		next = null;
	}
}

class LinkedList {
	ArrayList<Character> ar = new ArrayList();
	ArrayList<Character> ao = new ArrayList();

	public Node1 head;

	public LinkedList() {
		head = null;
	}

	public void add(char data) {
		Node1 n = new Node1(data);
		n.next = head;
		head = n;
	}

	public void reverse(Node1 head) {
		Node1 currNode = head;
		Node1 nextNode = null;
		Node1 prevNode = null;

		while (currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		head = prevNode;
		System.out.println("\n Reversed Linked List");
		display1(head);

	}

	public void display(Node1 head) {
		Node1 currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			ao.add(currNode.data);

			currNode = currNode.next;
		}

	}

	public void display1(Node1 head) {
		Node1 currNode1 = head;

		while (currNode1 != null) {
			System.out.print("->" + currNode1.data);
			ar.add(currNode1.data);

			currNode1 = currNode1.next;
		}

	}

	public void palindrome() {
		int t = ao.size();
		int count = 0;
		for (int i = 0; i < t; i++) {
			if (ao.get(i) == ar.get(i)) {
				count++;
			}
		}
		System.out.println();
		if (ao.size() == count) {
			System.out.println("The given linked list is palindrome");
		} else {
			System.out.println("The given linked list is not a palindrome");
		}
	}
}
