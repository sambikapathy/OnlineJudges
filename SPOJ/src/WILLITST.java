import java.util.HashSet;
import java.util.Scanner;


public class WILLITST {

	static HashSet<Long> set = new HashSet<Long>();
	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		long value  = z.nextLong();
		while(value>1){
//			if(set.contains(value)){
//				System.out.println("NIE");
//				break;
//			}
//			set.add(value);
			if(value%2==0){
				value/=2;
			}else{
//				value = value*3+3;
				break;
			}
		}
		if(value==1)
		System.out.println("TAK");
		else
			System.out.println("NIE");
	}

}
