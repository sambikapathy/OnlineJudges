package DynamicProgramming;

public class Staircase {
/*
 Staircase
  A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or
3 steps at a time. Implement a method to count how many possible ways the child
can run up the stairs

Two DP ways to solving this
1) Caching results from recursion
2) incrementa
 */
	
	
	public static int countWaysRec(int []input , int n){
		if(n == 0 ){
			return 1;
		}
		int count = 0;
		for(int i=0;i<input.length;i++){
			if(n-input[i] >= 0){
				count+=countWaysRec(input , n-input[i]);
			}
		}
//		System.out.println("count "+count);
		return count;
	}

	public static int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
		}
	}
	public static int countWays(int[] input , int n){
		int []output = new int[n+1];
		output[0] = 1;
		
//		for(int i : input){
//			output[i] = 1;
//		}
		for(int i=1;i<=n;i++){
			for(int j=0;j<input.length;j++){
				if(i-input[j]>=0){
					output[i]+= output[i-input[j]];
				}
			}
		}
		for(int i : output){
//			System.out.print(i+" ");
		}
		System.out.println("DP " + output[n]);
		return -1;
	}
	public static void main(String[] args) {
		int []input = {1,2,3};
		int n = 10;
		countWays(input , n);
		
		System.out.println("CTCL "+countWays(n));
		System.out.println("Rec "+ countWaysRec(input , n));
	}
}
