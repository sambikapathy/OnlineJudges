package problems;

public class GeneralProblems {

	public static int sumOfDigitsRec(int num) {
		if (num == 0) {
			return 0;
		}
		return num % 10 + sumOfDigitsRec(num / 10);
	}

	public static int add(int a , int b) {
		while(b!=0){
			int c = a&b;
			a = a ^b;
			b = c << 1;
		}
		return a;
	}

	public static int climb(int n){
		if(n<0){
			return 0;
		}else if(n==0){
			return 1;
		}
		return climb(n-1)+climb(n-2);
	}
	public static void main(String[] args) {
		
//		int input = 1234566445;
//		System.out.println(sumOfDigitsRec(input));

//		int a = 100, b = 150, c = 200;
//		System.out.println((a > b) ? (a > c ? a : c) : (b > c ? b : c));
//		
//		System.out.println(add(100,200));
//		
//		System.out.println(100&200);
		
		System.out.println(climb(2));
	}
}
