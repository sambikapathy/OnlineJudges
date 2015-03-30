package OnlineJudge.HackerRank;

import java.util.Scanner;

public class SherlockAndMiniMax {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		int p = in.nextInt();
		int q = in.nextInt();
		int min = Integer.MIN_VALUE;
		int minValue = 0;
		for(int i=p;i<=q;i++){
			int low = Integer.MAX_VALUE;
			int lowvalue = 0;
			for(int j=0;j<n;j++){
				int value = Math.abs(a[j]-i);
				if(value < low){
					low = value;
					lowvalue = i;
				}else if(value==low){
					if(lowvalue > i){
						lowvalue = i;
					}
				}
			}
			
			if(min < low || (min==low && minValue > lowvalue)){
				min = low;
				minValue = lowvalue;
			}
		}
		System.out.println(minValue);
	}
	
	

//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int []a = new int[n];
//		for (int i = 0; i < n; i++) {
//			a[i] = in.nextInt();
//		}
//		int p = in.nextInt();
//		int q = in.nextInt();
//		int min = Integer.MAX_VALUE;
//		int minValue = Integer.MAX_VALUE;
//		for(int i=p;i<=q;i++){
//			int low = Integer.MAX_VALUE;
//			int lowvalue = Integer.MAX_VALUE;
//			for(int j=0;j<n;j++){
//				int value = Math.abs(a[j]-i);
//				if(value < low){
//					low = value;
//					minValue = i;
//				}else if(value==min){
//					if(minValue > i){
//						minValue = i;
//					}
//				}
//			}
//		}
//		System.out.println(minValue);
//	}
}
