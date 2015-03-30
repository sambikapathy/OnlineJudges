

public class P12DivisibleTriangleNumber {

	public static void main(String[] args) {
		long sum =0 ;
		int i = 1;
		while(true){
			sum+=i++;
			int count = getDivisorCount(sum);
			if(count >500){
				System.out.println(sum);
				break;
			}
		}
	}
	
	private static int getDivisorCount(long input){
		int count =0;
		int sqrt = (int) Math.sqrt(input);
		for(int i=1;i<=sqrt;i++){
			if(input%i==0){
				count+=2;
			}
		}
		if(sqrt*sqrt == input){
			count--;
		}
		return count;
	}
}
