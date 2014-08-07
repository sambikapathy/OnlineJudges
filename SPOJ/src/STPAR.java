import java.util.Scanner;
import java.util.Stack;


public class STPAR {

	static Stack<Integer> st = new Stack<Integer>();
	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int total = z.nextInt();
		while(total!=0){
			int []array = new int[total];
			for(int i=0;i<total;i++){
				array[i] = z.nextInt();
			}
			int expected = 1;
			int index = 0;
			while(true){
				if(array[index] == expected){
					expected++;
					index++;
				}else if(!st.isEmpty() && st.peek() == expected){
					st.pop();
					expected++;
				}else{
					st.push(array[index++]);
				}
				if(index>=total){
					break;
				}
			}
			while(!st.isEmpty()){
				if(st.peek()==expected){
					st.pop();
					expected++;
				}else{
					System.out.println("no");
					break;
				}
			}
			if(expected==total+1){
				System.out.println("yes");
			}
			
			total = z.nextInt();
			st.clear();
		}
	}
}
