import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class HPYNOS {

	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		long value = z.nextLong();
		Set<Long> set = new HashSet<Long>();
		int index = 0;
		while(!set.contains(value) && value!=1){
			set.add(value);
			index++;
			long total = 0;
			while(value>0){
				int val = (int) (value%10);
				total+= val*val;
				value /=10; ;
			}
			value = total;
		}
		if(value==1){
			System.out.println(index);
		}else{
			System.out.println(-1);
		}
		
	}
}
