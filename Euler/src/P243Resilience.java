public class P243Resilience {

	public static void main(String[] args) {
		double max = 15499.0 / 94744;
//		System.out.println(max);
		for (int start = 100000; start < 200000; start++) {
			int count = 0;
			for (int i = 1; i < start; i++) {
				int value = (getGcd(i, start));
				if (value == 1)
					count++;
				double result = (count*1.0/start);
				if(result > max){
					break;
				}
			}
			double result = (count*1.0/start);
			if(result < max){
				System.out.println(start);
			}else{
//				System.out.println("##"+result);
			}
		}
	}

	static int getGcd(int a, int b) {
		if(a%2==0 && b%2==0){
			return 0;
		}
		
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
