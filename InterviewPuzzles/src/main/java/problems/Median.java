package problems;

import java.util.Random;

public class Median {

	private static int[] createArray(int n){
		int [] arr = new int[n];
		Random r = new Random();
		for(int i=0;i<n;i++){
			arr[i] = r.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int n = 4;
		int []arr = createArray(n);
		
		int c = n/2;
		int s =0 , e = n-1;
		while(s<e){
			while(arr[s] < arr[c])s++;
			while(arr[e] > arr[c])e--;
			int t = arr[s];
			arr[s] = arr[c];
			arr[c] = t;
		}
	}
}
