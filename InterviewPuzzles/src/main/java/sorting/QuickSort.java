package sorting;

public class QuickSort {

	public void qsort(int []input,int lo , int hi){		
		while(lo < hi){
			int p = getPivot(input);
			qsort(input , lo , p);
			qsort(input , p+1 , hi);
			
		}
	}
	
	private int getPivot(int[] input) {
//		int hi = input.length
	}

	public static void main(String[] args) {
		
	}
}
