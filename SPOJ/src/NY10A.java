import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class NY10A {

	static List<String> list = new ArrayList<String>();
	static{
		list.add("TTT");
		list.add("TTH");
		list.add("THT");
		list.add("THH");
		list.add("HTT");
		list.add("HTH");
		list.add("HHT");
		list.add("HHH");
	}
	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int total = z.nextInt();
		int index =0;
		while(index < total){
			z.nextInt();
			int []counts = new int[list.size()];
			String input = z.next();
			for(int j=0;j<input.length()-2;j++){
				String sub = input.substring(j,j+3);
				for(int i=0;i<list.size();i++){
					if(sub.equals(list.get(i))){
						counts[i] = counts[i]+1;
					}
				}
			}
			System.out.print(index+1);
			for(int i=0;i<list.size();i++){
				System.out.print(" "+counts[i]);
			}
			System.out.println();
			index++;
		}
	}
}
