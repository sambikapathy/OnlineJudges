package Recursion;

public class MinimumSizeSubArray_ProgramCreek {

	public static void main(String[] args) {
		int []input = {2,3,1,2,4,3};
		int s = 7;
//		System.out.println(minSubArray(input , s));
	}

	private static int minSubArray(int[] input, int target , int index , int count , int total) {
		if(index >= input.length){
			return Integer.MAX_VALUE;
		}
		
		for(int i=index;i<input.length;i++){
			
		}
		return -1;
	}
}
