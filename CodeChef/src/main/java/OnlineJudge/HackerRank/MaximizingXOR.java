package OnlineJudge.HackerRank;

import java.util.Scanner;

public class MaximizingXOR {

	 static int maxXor(int start, int end) {
		 int max = 0;
		 for(int i=start;i<end;i++){
			 for(int j=i;j<end;j++){
				 int val = i^j;
				 if(val > max)
					 max = val;
			 }
		 }
		 return max;

	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int res;
	        int _l;
	        _l = Integer.parseInt(in.nextLine());
	        
	        int _r;
	        _r = Integer.parseInt(in.nextLine());
	        
	        res = maxXor(_l, _r);
	        System.out.println(res);
	        
	    }
}
