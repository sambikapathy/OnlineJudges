package interviewbit;

import java.util.ArrayList;

public class Rearrange {

	public static void main(String[] args) {
		int []input = new int[]{4, 0, 2, 1, 3 };
//		int []input = new int[]{2, 2 , 0, 1};
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i : input){
			a.add(i);
		}
		new Rearrange().arrange(a);
		System.out.println(a);
		System.out.println(Math.sqrt(Integer.MAX_VALUE));
//		System.out.println(Integer.parseInt("0000111110101110010000111001100", 2));
//		int i = Integer.parseInt("0000111110101110010000111001100", 2);
//		i |= (1 << 31);
//		System.out.println(i);
//		printBits(i);
	}
//10000111110101110010000111001100
//10000111110101110010000111001100
	
	public void arrange(ArrayList<Integer> A) {
	    int n = A.size();
	    for (int i = 0; i < n; i++) {
	    	Integer index = A.get(i);
			A.set(i, index + (A.get(index) % n) * n );
	    }
	    for (int i = 0; i < n; i++) {
	    	A.set(i, A.get(i) / n);
	    }
	}
	
	
	public void arrange1(ArrayList<Integer> list) {
		
		for(int i=0;i<list.size();i++){
			int value = readHalfum(list.get(i), false);
			int temp = readHalfum(list.get(value), false);
			list.set(i, writeHalfum(temp, value));
		}
		for(int i=0;i<list.size();i++){
			list.set(i, readHalfum(list.get(i), true));
		}
	}
	private int readHalfum(int no, boolean isFirst){
		StringBuilder sb = new StringBuilder();
		int start = 0 , end = 0;
		if(isFirst){
			start+=16;
			end+=16;
		}
		for(int i=0;i<end+16;i++){
			if(i>=start){
				sb.append(no&1);
			}
			no= no>>1;
		}
		String reverse = (sb.reverse().toString());
		return Integer.parseInt(reverse, 2);
	}
	
	
	
	
	private static int writeHalfum(int first, int second){
		StringBuilder sb = new StringBuilder();
		int start = 0 , end = 0;
		
		for(int i=0;i<end+16;i++){
			if(i>=start){
				sb.append(first&1);
			}
			first= first>>1;
		}
		String temp = sb.reverse().toString();
		sb = new StringBuilder();
		for(int i=0;i<end+16;i++){
			if(i>=start){
				sb.append(second&1);
			}
			second= second>>1;
		}
		temp+= sb.reverse().toString();
//		Long.parseLong(arg0, arg1)
		if(temp.length() == 32 && temp.charAt(0)=='1'){
			int i = Integer.parseInt(temp.substring(1), 2);
			i |= (1 << 31);
			return i;
		}
		return Integer.parseInt(temp, 2);
	}
	
	private static void printBits(int no){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<32;i++){
				sb.append(no&1);
			no= no>>1;
		}
		String reverse = (sb.reverse().toString());
		System.out.println(reverse);
	}
}