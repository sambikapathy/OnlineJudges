import java.util.Arrays;
import java.util.Scanner;


public class EGYPIZZA {
//DP
	public static void main(String[] args) {
		Scanner z = new Scanner(System.in);
		int total = z.nextInt();
		float[] input = new float[total];
		for(int i=0;i<total;i++){
			String value = z.next();
			if(value.equals("1/2")){
				input[i] = .5f;
			}else if(value.equals("1/4")){
				input[i] = .25f;
			}else if(value.equals("3/4")){
				input[i] = .75f;
			}
		}
		Arrays.sort(input);
		float round = 1.0f;
		int count = 0;
		for(int i=0;i<input.length;i++){
			float rest = round - input[i]; 
			if( rest < 0.0){
				count++;
				round = 1.0f - input[i];
			}else if(rest > 0.0){
				round = rest;
			}else{
				count++;
				round = 1.0f;
			}
		}
		if(round>0.0f && round < 1.0f){
			count++;
		}
		
		System.out.println(count+1);
	}
}

/*
 * 9 
3/4 
1/2 
1/4 
1/4 
1/4 
1/4 
1/4 
1/4 
1/4 

*/