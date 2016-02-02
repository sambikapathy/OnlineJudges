package problems;

public class IntegerProblems{

	public static void main(String[] args) {
		int number = 1534236469;
//		System.out.println(isPalindrome(number , number));
		System.out.println(reverse(1534236469));
	}
	
	public static int atoi(){
		return -1;
	}
	
	private static int count = 1 , iter =1;
	
	public static boolean isPalindrome(int number , int original){
		if(number == 0){
			return true;
		}
		System.out.println(iter++);
		if(!isPalindrome(number/10 , original)){
			return false;
		}
		if(number%10 == (int)(original%(Math.pow(10, count))/Math.pow(10, count-1))){
			count++;
			return true;
		}else{
			return false;
		}
	}
	
	
	public static int reverse(int x) {
        boolean neg = x<0?true:false;
        int factor =0;
        int rev = 0;
        int prev = 0;
        while(x > 0){
            int temp = x%10;
            
            rev = (rev*10)+temp;
            System.out.println(rev + " " + factor);
            if(rev/10 != prev) 
                return 0;
            else 
                prev = rev;
            x=x/10;
        }
        return rev;
    }
}
