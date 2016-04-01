package LinkedList;

import java.util.Arrays;
import java.util.List;

public class SinglyLinkedList {

	Node head;

	public <T> SinglyLinkedList(List<T> input) {
		head = LinkedListHelper.createLinkedList(input);
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}
	public void printList(Node temp) {
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}

	public <T> void insertAtFront(T value) {
		Node node = new Node(value);
		node.next = head;
		head = node;
	}

	public <T> void insertAtEnd(T value) {
		Node node = new Node(value);
		node.next = null;
		Node temp = head;

		if (head == null) {
			head = node;
			return;
		}
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	public <T> void delete(T value) {
		Node temp = head;
		if (temp == null)
			return;

		if (temp.data == value) {
			head = temp.next;
			return;
		}

		while (temp.next != null && temp.next.data != value) {
			temp = temp.next;
		}

		if (temp.next != null) {
			temp.next = temp.next.next;
		}
	}

	public <T> void insertAfter(Node prev, T value) {
		if (prev == null)
			return;

		Node start = prev;
		// while(start !=null && start != prev){
		// start = start.next;
		// }
		Node node = new Node(value);
		if (start != null) {
			// 1-2-3
			node.next = start.next;
			start.next = node;
		}

	}

	public <T> Node<T> get(int index) {
		Node current = head;

		for (int i = 0; i < index && current != null; i++)
			current = current.next;

		return current;
	}

	public int lengthIter(Node first) {
		int length = 0;
		while (first != null) {
			length++;
			first = first.next;
		}
		return length;
	}

	// PREP proper way to do recursion without extra variable
	public int lengthRec(Node first) {
		if (first == null)
			return 0;
		return 1 + lengthRec(first.next);
	}

	public <T> boolean searchIter(Node first, T value) {
		while(first != null ){
			if(value == first.data){
				return true;
			}
			first = first.next;
		}
		return false;
	}

	public <T> boolean searchRec(Node first, T value) {
		if(first == null){
			return false;
		}
		if(first.data == value){
			return true;
		}
		return searchRec(first.next, value);
	}

	
	public void getNthNodeFromEnd(Node first , int index){
		Node temp = first;
		for(int i=0;i<index && temp != null;i++){
			temp = temp.next;
		}
		
		Node sec = first;
		while(temp.next != null){
			temp = temp.next;
			sec = sec.next;
		}
		System.out.println(index+" th node from last is "+sec.data);
	}
	
	public void printNthFromLast( Node first, int n) 
	{
	     int i = 0;
	    if(head == null)
	       return;
	    printNthFromLast(first.next, n);
	    if(++i == n)
	       System.out.println(first.data);
	}
	
	public void reverseList(Node first){
		Node temp = first;
		Node prev = null;
		while(temp != null){
			Node link = temp.next;
			temp.next = prev;
			prev = temp;
			temp = link;
		}
		head = prev;
	}
	
	public void reverseRec(Node first){
		if(first.next == null){
			head = first;
			return;
		}
		reverseRec(first.next);
		first.next.next = first;
	}
	
	//PREP reversing without special case checking
	public void reverseRec(Node current , Node prev){
		if(current.next == null){
			head = current;
			current.next = prev;
			return;
		}
		Node next = current.next;
		current.next = prev;
		reverseRec(next, current);
		
		
	}
	//PREP
	/*
	 * 1) Hashing : store memory address and return true 
	 * 2) Modify node to contain a visited attribute
	 * 3) Floyd's cycle finding algorithm : two pointers
	 */
	public boolean isThereLoop(Node current){
		Node one = current;
		Node two = current.next;
		
		while(two.next != null){
			if(one == two){
				return true;
			}
			one = one.next;
			two = two.next.next;
		}
		return false;
	}
	
	//PREP
	/*1) Stack: store the values in stack
	 *2) Get middle of list. Reverse second half of list. See whether list are identical. Reverse and reattach the second half to first
	 *3) Recursion.
	 */
	
	private  Node palinTemp ;
	public boolean isPalindrome(Node last){
		// 1 - 2 - 3 - 2 - 1
		if(last== null){
			return true;
		}
		if(!isPalindrome( last.next)){
			return false;
		}
		
		boolean result = palinTemp.data == last.data;
		palinTemp = palinTemp.next;
		return result;
		
	}
	
	public void insert(Node first , int value){
		Node insertNode = new Node(value);
		Node current = first;
		Node prev = null;
		while(current != null && ((Integer)current.data) < value){
			prev = current;
			current = current.next;
		}
		if(prev == null){
			insertNode.next = head;
			head = insertNode;
		}else{
			insertNode.next = prev.next;
			prev.next = insertNode;
		}
		
	}
	
	public void printReverse(Node first){
		if(first == null){
			return;
		}
		printReverse(first.next);
		System.out.println(first.data);
	}
	
	public void removeDuplicates(Node first){
		if(first == null){
			return;
		}
		int last = (Integer)first.data;
		
		Node prev = first;
		first = first.next;
		while(first != null){
			int data = (Integer)first.data;
			if(data == last){
				prev.next = first.next;
			}
			last = (Integer)first.data; 
			first = first.next;
		}
	}
	
	public void pairSwapIter(Node first){
		Node one = first;
		Node two = first.next;
		while(one != null && two != null){
			Object t1 = one.data;
			one.data = two.data;
			two.data = t1;
			
			one = two.next;
			two = one.next;
		}
	}
	
	public void moveToFront(Node first){
		Node prev = null;
		while(first.next != null){
			prev = first;
			first = first.next;
		}
		prev.next = null;
		first.next = head;
		head = first;
		
	}
	
	//PREP good recursion
	public void sortedIntersectionRec(Node first , Node second){
		
	}
	
	public void deleteAlternateNodesRec(Node first){
		if(first == null || first.next == null){
			return;
		}
		
		Node temp = first;
		
		first.next = first.next.next;
		deleteAlternateNodesRec(first.next);
	}
	
	//PREP recursion
	public Node mergeRec(Node a , Node b){
		Node temp = null;
		if(a == null){
			return b;
		}
		if(b==null){
			return a;
		}
		
		if((Integer)a.data <= (Integer)b.data){
			temp = a;
			temp.next = mergeRec(a.next, b);
		}else if((Integer)a.data > (Integer)b.data){
			temp = b;
			temp.next = mergeRec(a, b.next);
		}
		return temp;
	}
	
	
	//PREP merge sort
	
	public void mergeSort(Node first){
		if(first == null || first.next == null){
			return;
		}
	}
	
	//PREP revisit for simpler recursion logic 
	//1 - 2 - 3 - 4 - 5
	public Node reverseInGroup(Node first, int k) {
		int count = 0;
		Node temp = first;
		Node next = null;
		Node prev = null;
		while (count < k && temp != null) {
			 next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
			count++;
		}

		if (temp != null) {
			first.next = reverseInGroup(temp, k);
		}
		return prev;
	}
	
	//PREP move all odd numbers to the end.
	//Input: 17->15->8->12->10->5->4->1->7->6->NULL
    //Output: 8->12->10->4->6->17->15->5->1->7->NULL
	public void segregate(Node first){
		Node last = findLastNode(first);
		Node newHead = null;
		Node current = first;
		Node newLast = last;
		while( (Integer)current.data %2 != 0 && newLast != current){
			last.next = current;
			current = current.next;
			last.next.next = null;
			last = last.next;
		}
		
		// 2 - 3 - 5 - 4-1
		if((Integer)current.data % 2== 0){
			newHead = current;
			Node prev = null;
			while(current.next != null && current != newLast.next){
				if((Integer)current.data %2 == 0){
					prev = current;
					current = current.next;
					
				}else{
					last.next = current;
					prev.next = current.next;
					current = current.next;
					current.next = null;
					last.next.next = null;
					last = last.next;
				}
			}
		}
		
		if(newLast != last && (Integer)newLast.data %2 !=0){
			last.next = newLast;
			current = current.next;
			newLast.next = null;
		}
		if(newHead == null)
		newHead = current;
		head = newHead;;
	}
	private Node findLastNode(Node first) {
		if(first == null || first.next == null){
			return first;
		}
		Node temp = first;
		while(temp.next != null){
			temp = temp.next;
		}
		return temp;
	}

	//For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
	//SRINI
	//Partition
	//LRU cache using both DLL and HashMap + MinHeap combo
	//inorder , pre order and post order iterative
	//level oder traversal like {[1] , [2,3] , [4,5,6,7]}
	//Bottom up level order traversal
	//flatten a tree to a list
	/*1
	/ \
	2 5
	/ \ \
	3 4 6
	The flattened tree should look like:
	1
	\
	2
	\
	3
	\
	4
	\
	5
	\
	
	6
	*/
	//Add and Search Word Data structure design
	
	private Node partitionList(Node first , int x){
		
		Node<Integer> great = new Node(0);
		Node<Integer>  less = new Node(0);
		
		Node<Integer>  p = first;
		Node<Integer> g = great;
		Node<Integer> l = less;
		Node<Integer> prev = null;
		
		while(p != null){
			if(p.data > x){
				g.next = p;
			}else{
				
			}
		}
		return null;
	}
	public static void main(String[] args) {
		Integer[] input = {1,2,3 };
		Integer[] input2 = { 50 , 10, 16, 23, 24, 25 };

		SinglyLinkedList list = new SinglyLinkedList(Arrays.asList(input));
		SinglyLinkedList list2 = new SinglyLinkedList(Arrays.asList(input2));
//		list.printList();

//		list.insertAtFront(10);
//		list.printList();
//
//		Node nodeAtPosition = list.get(3);
//
//		list.insertAfter(nodeAtPosition, 20);
//		list.printList();
//
//		list.insertAtEnd(100);
//		list.printList();
//
//		// DELETE
//		list.delete(100);
//		list.delete(10);
//		list.printList();
//
//		System.out.println(list.lengthIter(list.head));
//
//		System.out.println(list.lengthRec(list.head));
//		
//		list.getNthNodeFromEnd(list.head, 1);
		
//		list.reverseList(list.head);
//		list.printList();
//		
//		list.reverseList(list.head);
//		list.printList();
//		Node old = list.head;
//		list.reverseRec(list.head);
//		old.next = null;
//		list.printList();
//		
//		list.reverseRec(list.head, null);
//		list.printList();
//		list.get(3).next = list.get(1);
//		System.out.println("Is there loop : "+list.isThereLoop(list.head));
		
//		list.palinTemp = list.head;
//		System.out.println(list.isPalindrome(list.head));
//		list.insert(list.head, 1);
//		list.printList();
		
//		list.printReverse(list.head);
//		list.removeDuplicates(list.head);
//		list.printList();
//		list.pairSwapIter(list.head);
//		list.moveToFront(list.head);
//		list.printList();
		
//		list.deleteAlternateNodesRec(list.head);
//		list.mergeRec(list.head, list2.head);
//		list.printList(list.reverseInGroup(list.head, 2));
//		list.printList();
//		list.segregate(list.head);
//		list.printList();
		
		list.printList();
		list.partitionList(list2.head, 20);
		list.printList();
	}

}
/*
 * Merge sort
 * segregate list
 * Intersection of two nodes
 */
