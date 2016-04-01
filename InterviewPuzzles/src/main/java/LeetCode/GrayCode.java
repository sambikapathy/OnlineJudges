package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

	/*
For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

000
001
010
011
100
101
110
111


000
001
011
010
110
111
101
100




         0
      1  2   4
     3  3 5 6


      0
     1 2
    3
	 */
	static List<String> base = new ArrayList<String>();
	static List<Integer> base2 = new ArrayList<Integer>();
	static{
		base.add("0");
		base.add("1");
		
		base2.add(0);
		base2.add(1);
	}
	public List<String> grayCode(int n ) {
		if(n==1){
			return base;
		}
		List<String> input = grayCode(n-1);
		List<String> newList = new ArrayList<String>();
		int index = 0;
		for(String line : input){
			if(index == 0 || isOffByOne(newList.get(index-1) , line+"0")){
				newList.add(line+"0");
				newList.add(line+"1");
			}else{
				newList.add(line+"1");
				newList.add(line+"0");
			}
			index+=2;
		}
		return newList;
	}
	
	public List<Integer> grayCode2(int n ) {
		if(n==1){
			return base2;
		}
		List<Integer> input = grayCode2(n-1);
		List<Integer> newList = new ArrayList<Integer>();
		int index = 0;
		for(Integer line : input){
			if(index == 0 || isOffByOne2(newList.get(index-1) , line<<1)){
				newList.add(line<<1);
				newList.add(line<<1 | 1);
			}else{
				newList.add(line<<1 | 1);
				newList.add(line<<1);
			}
			index+=2;
		}
		return newList;
	}
	
	
	private boolean isOffByOne2(Integer x, Integer y) {
		int diff = 0;
		while(x > 0 || y > 0){
			if((x&1) != (y&1)){
				diff++;
				if(diff > 1){
					return false;
				}
			}
			
			x=x>>1;
			y=y>>1;
		}
		return true;
	}

	private boolean isOffByOne(String string, String string2) {
		int diff = 0;
		for(int i=0;i<string.length();i++){
			if(string.charAt(i) != string2.charAt(i)){
				diff++;
				if(diff > 1){
					return false;
				}
			}
		}
		return true;
	}


	public static void main(String[] args) {
		int n =2;
//		print(new GrayCode().grayCode(n));
//		System.out.println("$$$$$$$$$");
		print2(new GrayCode().grayCode2(n));
		
		
	}

	private static void print2(List<Integer> grayCode) {
		for(Integer str : grayCode){
			System.out.println(str);
		}
	}
	
	private static void print(List<String> grayCode) {
		for(String str : grayCode){
			System.out.println(Integer.parseInt(str,2));
		}
	}
	
}
