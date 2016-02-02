package sorting;

public class SortingAlgorithms {

	public static void bubbleSort(int []input){
		
		boolean isDone = false;
		while(!isDone){
			isDone = true;
			for(int i=0;i<input.length-1;i++){
				if(input[i] > input[i+1]){
					int t = input[i+1];
					input[i+1] = input[i];
					input[i] = t;
					isDone = false;
				}
			}
			
		}
	}
	
	public static void selectionSort(int []input){
		for(int i=0;i<input.length;i++){
			int low = i;
			int min = input[i];
			
			for(int j=i+1;j<input.length;j++){
				if(input[j] < min ){
					min = input[j];
					low = j;
				}
			}
			
			if(i != low){
				int t = input[low];
				input[low] = input[i];
				input[i] = t;
			}
		}
	}
	//0,1,2,3,4,5
	//0,2,
	public static void merge(int []input ,  int l , int m , int r){
		int ls = m-l+1;
		int rs = r-m;
		
		int []la = new int[ls];
		int []ra = new int[rs];
		
		for(int i=0;i<ls;i++){
			la[i] = input[l+i];
		}
		
		for(int j=0;j<rs;j++){
			ra[j] = input[m+j+1];
		}
		int i=0 , j=0 , index = l;
		while(i<ls && j < rs){
			if(la[i] <= ra[j]){
				input[index++] = la[i++];
			}else{
				input[index++] = ra[j++];
			}
		}
		
		while(i<ls){
			input[index++] = la[i++];
		}
		
		while(j < rs){
			input[index++] = ra[j++];
		}
	}
	public static void mergeSort(int []input,int l , int r){
		if(l < r){
			int m = (l+r)/2;
			mergeSort(input , l , m);
			mergeSort(input , m+1 , r);
			merge(input,l,m,r);
		}
	}
	
	
	public static void quickSort(int []input , int l , int r){
		if(l >= r){
			return;
		}
		
		int mid = pivot(input , l , r);
		
		quickSort(input , l , mid -1);
		quickSort(input ,   mid +1 , r);
	}
	
	private static int pivot(int[] input, int l, int r) {
		int p = input[(l+r)/2];
		swap(input , p , r);
		while(l < r-1){
			if(){
				
			}
		}
		return 0;
	}

	private static void swap(int[] input, int l, int r) {
		int t = input[r];
		input[r] = input[l];
		input[l] = t;
		
	}

	public static void printArray(int []input){
		for(int i: input){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int size = 10;
		int [] input = new int[size];
		for(int i=0;i<size;i++){
			input[i] = (int)(Math.random() * 100);
		}
		printArray(input);
//		bubbleSort(input);
//		selectionSort(input);
		mergeSort(input , 0 , size-1);
		printArray(input);
		
		
	}
}
