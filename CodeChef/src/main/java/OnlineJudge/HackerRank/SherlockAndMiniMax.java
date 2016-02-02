package OnlineJudge.HackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class SherlockAndMiniMax {

	/*
50
58 124 284 300 368 604 626 772 1014 1542 1662 1700 2330 2402 2416 2540 2666 3018 3268 3444 3576 3746 4160 4224 4292 4354 4404 4552 4922 4924 5068 5224 5462 5528 5812 5996 6088 6132 6468 6672 6738 7180 7184 7230 7268 7362 7414 7436 7616 7764
2518 4111


3953
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int []a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		Arrays.sort(a);
		
		int p = in.nextInt();
		int q = in.nextInt();
		
		int l =  Integer.MIN_VALUE;
		int r =  Integer.MIN_VALUE;
		
		int lv = -1 , rv = -1;
		
		if(a[0]>p){
			l = Math.abs(p-a[0]);
			lv = p;
		}
		if(q> a[n-1]){
			r = Math.abs(q-a[n-1]);
			rv = q;
		}
		
		int diff = Integer.MIN_VALUE;
		int dv=-1;
		
		for(int i=0;i<n-1;i++){
			int one = a[i];
			int two = a[i+1];
			
			if(one < q && q < two){
				if(q-one <= two-q){
					two = q+(q-one);
				}
			}
			if((one> p && one< q) || (one< p && two > p)){
				
				int value = Math.abs(one-two)/2;
				int cv = (one+two)/2;
				if(diff < value || (diff == value && dv > cv)){
					diff = value;
					dv = cv;
				}
			}
		}
		
		if(l < r){
			if(r < diff){
				System.out.println(dv);
			}else{
				System.out.println(rv);
			}
		}else{
			if(l<diff){
				System.out.println(dv);
			}else{
				System.out.println(lv);
			}
		}
	}
}
