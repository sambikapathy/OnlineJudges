package OnlineJudge.HackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class IsFibo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		BigInteger five = new BigInteger("5");
		BigInteger four = new BigInteger("4");
		for(int i=0;i<n;i++){
			BigInteger input = new BigInteger(in.next());
			BigInteger value = five.multiply(input).multiply(input).add(four);
			BigInteger value2 = five.multiply(input).multiply(input).subtract(four);
			if(isPerfectSquare(value) || isPerfectSquare(value2)){
				System.out.println("IsFibo");
			}else{
				System.out.println("IsNotFibo");
			}
		}
	}
	
	private static BigInteger sqrt(BigInteger n) {
		  BigInteger a = BigInteger.ONE;
		  BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
		  while(b.compareTo(a) >= 0) {
		    BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
		    if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
		    else a = mid.add(BigInteger.ONE);
		  }
		  return a.subtract(BigInteger.ONE);
		}
	
	private static boolean isPerfectSquare(BigInteger target){
		BigInteger result = sqrt(target);
		if(result.multiply(result).equals(target)){
			return true;
		}
		return false;
	}
}
