package interviewbit;

public class Factorial {

	public static void main(String[] args) {
		new Factorial().trailingZeroes(9247);
	}
	 public int count = 0;
		public int trailingZeroes(int a) {
		    //int count = 0;
		    long res = fib(a);
		    while(res%10 == 0){
		        count++;
		        res/=10;
		    }
		    return count;
		}
		
		public long fib(int i){
		    if(i<=1) return 1;
		    while(i%10 == 0){
		        count++;
		        i/=10;
		    }
		    return i*1l*fib(i-1);
		}
}
