package LinkedList;

public class Node<T> {
	@Override
	public String toString() {
		return data + "";
	}

	public T data;
	public Node<T> next;
	public Node<T> prev;

	public Node() {
	}

	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getPrev() {
		return prev;
	}

	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

}