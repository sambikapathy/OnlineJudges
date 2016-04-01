package DynamicProgramming;

public class HouseRobber {
//50 1 1 50
	/**
	 * @param num
	 * @return
	 */
	/**
	 * @param num
	 * @return
	 */
//	public int rob(int[] num) {
//		int []result = new int[num.length];
//		result[0] = num[0];
//		result[1] = num[1];
//		for(int i=2;i<num.length;i++){
//			int max = Integer.MIN_VALUE;
//			for(int j=i-2;j>=0;j--){
//				if(result[j] > max){
//					max = result[j];
//				}
//			}
//			result[i] =  max+num[i];
//		}
//		for(int i : result){
//			System.out.print(i+" ");
//		}
//		return result[num.length-1];
//	}
	
	public int rob(int num[]){
		int []result = new int[num.length+1];
		result[0] = 0;
		result[1] = num[0];
		
		for(int i=2;i<num.length+1;i++){
			result[i]  = Math.max(result[i-1] , result[i-2]+num[i-1]); 
		}
		return result[num.length];
	}
	public static void main(String[] args) {
		int []input = {50,1,1,50};
		System.out.println(new HouseRobber().rob(input));
	}
}
