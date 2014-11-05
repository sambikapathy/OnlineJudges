package problems;

public class LongestIncreasingSubsequence {

	public static int findLISS(int []input){
		int []max = new int[input.length];
		max[0] = 1;
		for(int i=1;i<input.length;i++){
			int count = 1;
			for(int j=0;j<i;j++){
				if(input[i] > input[j]){
					if(max[j]+1 > count){
						count = max[j]+1;
					}
				}
			}
			max[i] = count;
		}
		int result = 0;
		for(int i : max){
			if(i > result)
				result = i;
		}
		return result;
	}
	public static void main(String[] args) {
		int []input = {1,5,2,8,6,10,2,9,14,3};
		System.out.println(findLISS(input));
	}
}
