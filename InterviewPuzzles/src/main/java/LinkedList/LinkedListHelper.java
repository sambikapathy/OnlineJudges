package LinkedList;

import java.util.List;

public class LinkedListHelper {

	public static <T> Node<T> createLinkedList(List<T> list){
		Node<T> head = null;
		Node<T> prev = null;
		for(T input : list){
			Node<T> temp = getNode(input);
			if(prev == null){
				head = temp;
			}else{
				prev.setNext(temp);
			}
			prev = temp;
		}
		return head;
	}
	
	private static <T> Node<T> getNode(T data){
		Node<T> node = new Node<T>();
		node.setData(data);
		return node;
	}
}
