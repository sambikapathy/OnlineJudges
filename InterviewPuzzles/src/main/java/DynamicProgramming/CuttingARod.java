package DynamicProgramming;

public class CuttingARod {
//http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
	/*
	 * length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20

o/p : 22
	 */
	int cutRod(int price[], int n){
		
		int []result = new int[n+1];
		result[0] = 0;
		for(int i=1;i<=n;i++){
			for(int j=0;j<i;j++){
					if(result[i] < price[j]+ result[i-j-1]){
						result[i] = price[j]+ result[i-j-1];
					}
			}
		}
		for(int i : result){
			System.out.print(i+" ");
		}
		System.out.println();
		return result[n];
	}
	
	public static void main(String[] args) {
		int []price = {1   ,5 ,  8  , 9,  10 , 17 , 17  ,20};
		int n = 8;
		System.out.println(new CuttingARod().cutRod(price , n));
	}
	
}
