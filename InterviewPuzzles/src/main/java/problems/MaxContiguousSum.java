package problems;

public class MaxContiguousSum {

	public static int maxSum(int []input){
		int max [] = new int[input.length];
		max[0] = input[0];
		for(int i=1;i<input.length;i++){
			if(max[i-1]+input[i] > input[i]){
				max[i] = max[i-1]+input[i];
			}else{
				max[i] = input[i];
			}
		}
		int result = max[0];
		for(int i=1;i<max.length;i++){
			if(max[i] > result)
				result = max[i];
		}
		return result;
	}
	public static void main(String[] args) {
		int  [] input = {2,6,1,-9,3,4};
		System.out.println(maxSum(input));
	}
}
