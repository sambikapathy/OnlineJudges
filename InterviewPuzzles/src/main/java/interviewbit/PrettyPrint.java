package interviewbit;

import java.util.ArrayList;

public class PrettyPrint {

	public static ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	    int size = 2*a -1;
	    ArrayList<ArrayList<Integer>> input = getList(size);
	    
	   
	    int cs = size;
	    int rs = size;
	   int current = a;
	    for(int i=0;i<a;i++){
	   
	   //l-r
	    for(int j=i;j<cs;j++){
	        input.get(i).set(j , current);
	        input.get(rs-1).set(j,current);
	    }
	    
	    //t-b
	    for(int j=i;j<rs;j++){
	        input.get(j).set(cs-1, current);
	        input.get(j).set(i,current);
	    }
	    
	    	rs-=1;
	    	cs-=1;
	        current--;
	    }
	    return input;
	}
	
	private static ArrayList<ArrayList<Integer>> getList(int size) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<size;i++){
			ArrayList<Integer> t = new ArrayList<Integer>();
			for(int j=0;j<size;j++){
				t.add(0);
			}
			list.add(t);
		}
		return list;
	}

	private static void print(int [][]a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
	int a = 9;
//		print(prettyPrint(a));
	}
}
