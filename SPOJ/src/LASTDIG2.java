import java.math.BigInteger;
import java.util.Scanner;


public class LASTDIG2 {

	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int total = z.nextInt();
		int []two = new int[]{6,2,4,8};
		int []three = new int[]{1,3,9,7};
		int []four = new int[]{6,4};
		int []seven = new int[]{3,7,9};
		int []eight = new int[]{6,8,4,2};
		int []nine = new int[]{9,1};
		
		for(int i=0;i<total;i++){
			BigInteger a1 = new BigInteger( z.next());
			int a = a1.mod(new BigInteger("10")).intValue();
			BigInteger b1 = new BigInteger(z.next());
			
			if(a==0)System.out.println(0);
			if(a==1||a==5||a==6)System.out.println(a);
			if(a==2){
				System.out.println( two[b1.mod(new BigInteger("4")).intValue()]);
			}
			if(a==3){
				System.out.println( three[b1.mod(new BigInteger("4")).intValue()]);
			}
			if(a==4){
				System.out.println( four[b1.mod(new BigInteger("2")).intValue()]);
			}
			if(a==7){
				System.out.println( seven[b1.mod(new BigInteger("3")).intValue()]);
			}
			if(a==8){
				System.out.println( eight[b1.mod(new BigInteger("4")).intValue()]);
			}
			if(a==9){
				System.out.println( nine[b1.mod(new BigInteger("2")).intValue()]);
			}
		}
		
	}
}
