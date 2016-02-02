package tree;

public class BinaryHeap {


	int capacity;
	int []array;
	int size = 0;
	
	public BinaryHeap(int capacity){
		this.capacity = capacity;
		array = new int[capacity];
	}
	
	public void insert(int data){
		size++;
		array[size] = data;
	}
	
	public void delete(int i){
		
	}

	public int getMin(){
		return array[0];
	}
	
	public int extractMin(){
		return array[0];
	}
	
	public int getLeft(int index){
		return 2*index + 1;
	}
	
	public int getRight(int index){
		return 2*index + 2;
	}
	
	public int getParent(int i){
		return (i-1)/2;
	}
	
	public void minHeapify(int start){
		
	}
	
}
