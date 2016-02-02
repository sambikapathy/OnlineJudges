package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CntBits {

	 public int cntBits2(ArrayList<Integer> a) {
	        int n = a.size();
	        long sum = 0;
	        long mod = (long)Math.pow(10,9)+7;
	        for(int i=0;i<n-1;i++){
	            for(int j=i;j<n;j++){
	               sum+= getBits(a.get(i) , a.get(j)); 
	            }
	            sum = sum % mod;
	        }
	        return (int)sum*2;
	    }
	 
	 public int cntBits(ArrayList<Integer> a) {
	        int n = a.size();
	        long sum = 0;
	        long mod = (long)Math.pow(10,9)+7;
	        int v = a.get(0);
	        for(int i=1;i<n;i++){
	           v^=a.get(i);
	        }
	        v = getSetBits(v);
	        return (int)sum*2;
	    }
	    public int getBits(int i , int j){
	        int t = i ^ j;
	        return getSetBits(t);
	    }
	    
	    public int getSetBits(int i){
	        int t = 0;
	        while(i > 0){
	            t++;
	            i = i& (i-1);
	        }
	        return t;
	    }
	    
	    public static void main(String[] args) {
	    	Integer [] input = {1,3,5};
			List<Integer> list = Arrays.asList(input);
			System.out.println(new CntBits().cntBits(new ArrayList<Integer>(list)));
		}
}
