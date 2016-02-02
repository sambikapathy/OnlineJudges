package Recursion;

public class TugOfWar {
/*
 For example, let given set be {3, 4, 5, -3, 100, 1, 89, 54, 23, 20}, the size of set is 10. 
 Output for this set should be {4, 100, 1, 23, 20} and {3, 5, -3, 89, 54}. 
 Both output subsets are of size 5 and sum of elements in both subsets is same (148 and 148).
 
 Tug of War
 http://www.geeksforgeeks.org/tug-of-war/
	 
 */
	
	private static int min = Integer.MAX_VALUE;
	public static int tow(int [] input , int lsu ,  int lsi , int rsu , int rsi , int index){
		if(index == input.length){
			if(Math.abs(lsu-rsu) < min){
				min = Math.abs(lsu-rsu);
			}
			return min;
		}
		tow(input , lsu+input[index] , lsi+1 , rsu , rsi , index+1);
		tow(input , lsu , lsi , rsu+input[index] , rsi+1 , index+1);
		return min;
	}
	public static void main(String[] args) {
		int []input = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
		System.out.println(tow(input , 0 , 0 , 0,0,0));
	}
}
