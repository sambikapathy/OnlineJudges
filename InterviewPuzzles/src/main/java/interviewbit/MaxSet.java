package interviewbit;

import java.util.ArrayList;

public class MaxSet {

	// [ 336465782, -278722862, -2145174067, 1101513929, 1315634022,
	// -1369133069, 1059961393, 628175011, -1131176229, -859484421 ]

	public static void main(String[] args) {
//		int []ar = new int[]{336465782, -278722862, -2145174067, 1101513929, 1315634022,-1369133069, 1059961393, 628175011, -1131176229, -859484421};
		int []ar = new int[]{24115, -75629, -46517, 30105, 19451, -82188, 99505, 6752, -36716, 54438, -51501, 83871, 11137, -53177, 22294, -21609, -59745, 53635, -98142, 27968, -260, 41594, 16395, 19113, 71006, -97942, 42082, -30767, 85695, -73671};
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i : ar){
			a.add(i);
		}
		System.out.println(new MaxSet().maxset(a));
	}
	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    long max = 0;
	    long sum = 0;
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    for(int i=0;i<a.size();i++){
	        int val = a.get(i);
	        if(val >= 0){
	            temp.add(val);
	            sum+=val;
	        }else{
	            if(sum > max || (sum == max && result.size() < temp.size())){
	                max = sum;
	                result = temp;
	            }
	            temp = new ArrayList<Integer>();
	            sum = 0;
	        }
	    }
	    if(sum > max || (sum == max && result.size() < temp.size())){
            max = sum;
            result = temp;
            temp = new ArrayList<Integer>();
        }
	    return result;
	}
}
