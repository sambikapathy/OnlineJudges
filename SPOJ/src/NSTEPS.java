import java.util.Scanner;


public class NSTEPS {

	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int total = z.nextInt();
		for(int i=0;i<total;i++){
			int x = z.nextInt();
			int y = z.nextInt();
			int mod = Math.abs(x-y);
			if(x >y){
				System.out.println("No Number");
			}else if(x %2==0){
				if(mod==0 || mod==2){
					System.out.println(x+y);
				}else{
					System.out.println("No Number");
				}
			}else{
				if(mod == 0 || mod ==2){
					System.out.println(x+y-1);
				}else{
					System.out.println("No Number");
				}
			}
		}
		
	}
}
