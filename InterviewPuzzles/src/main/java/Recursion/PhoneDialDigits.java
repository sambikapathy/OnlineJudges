package Recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDialDigits {

	private static final Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();

	static{
		map.put(2, Arrays.asList("a","b","c"));
		map.put(3, Arrays.asList("d","e","f"));
		map.put(4, Arrays.asList("g","h","i"));
	}
	
	
	public static void generateDigits(String prefix , String input , int index){
		if(index >= input.length()){
			System.out.println(prefix);
			return;
		}
		
		int val = input.charAt(index)-'0';
		for(String str : map.get(val)){
			generateDigits(prefix+str , input , index+1);
		}
	}
	
	public static void main(String[] args) {
		String input = "423";
		generateDigits("" , input , 0);
	}
}
