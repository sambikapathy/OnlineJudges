import java.util.Arrays;


public class STAMPS {

	public static void main(String[] args) throws Exception {
		java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
	    
		int count = Integer.parseInt(r.readLine());
		for (int i = 0; i < count; i++) {
			String input1[] = r.readLine().split(" ");
			int needed = Integer.parseInt(input1[0]);
			int friends = Integer.parseInt(input1[1]);
			int []list = new int[friends];
			String []array = r.readLine().split(" ");
			for(int j=0;j<friends;j++){
				list[j] = Integer.parseInt(array[j]);
			}
			Arrays.sort(list);
			int result =0;
			System.out.println("Scenario #"+(i+1)+":");
			for(int j=friends-1;j>=0;j--){
				needed-=list[j];
				result++;
				if(needed <=0){
					System.out.println(result);
					break;
				}
			}
			if(needed>0){
				System.out.println("impossible");
			}
			System.out.println();
		}

	}

	
}
