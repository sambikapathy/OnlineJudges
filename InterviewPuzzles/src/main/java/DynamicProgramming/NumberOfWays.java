package DynamicProgramming;

public class NumberOfWays {

	static int []input = {1,3,4};
	static int n = 1000000;
	
	//4-> 3 , 1 , 0
	public static int getWays(int n){
		int []out = new int[n+1];
		out[0] = out[1] = out[2] = 1;
		out[3] = 2;
		for(int i=4;i<=n;i++){
			for(int j=0;j<input.length;j++){
			out[i] += out[i-input[j]];
			}
		}
		return out[n];
	}
	
	public static int getWays2(int n){
		int []out = new int[n+1];
		out[0] = out[1] = out[2] = 1;
		out[3] = 2;
		for(int i=4;i<=n;i++){
			for(int j=0;j<input.length;j++){
			out[i] += out[i-input[j]];
			}
		}
		return out[n];
	}
	
	public static void main(String[] args) {
		System.out.println(getWays(n));
	}
}
