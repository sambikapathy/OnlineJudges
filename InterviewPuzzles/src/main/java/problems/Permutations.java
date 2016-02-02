package problems;

import java.util.ArrayList;



public class Permutations {

	public static void printPerm(String prefix , String input){
		if(input.length()==0){
			System.out.println(prefix);
			return;
		}
		for(int i=0;i<input.length();i++){
			if(i-1 >= 0)
			printPerm(prefix+input.charAt(i), input.substring(0, i)+input.substring(i+1));
			else
				printPerm(prefix+input.charAt(i), input.substring(i+1));
		}
		//prefix+=input.charAt(location);
		//printPerm(prefix, input, location+1);
	}

	
	ArrayList<String> q = new ArrayList<String>();
	
	public static void printP1(String input){
		for(int i=0;i<input.length();i++){
			char c = input.charAt(i);
//			for(){
//				
//			}
		}
	}
	
	public static void main(String[] args) {
		
		String input = "abc";
		printPerm("", input);
		
	}
}
