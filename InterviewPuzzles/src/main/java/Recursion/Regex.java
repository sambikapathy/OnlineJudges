package Recursion;

public class Regex {

	public static boolean isMatching(String input , String pattern ,int i , int p){
		if(input==null || input.length()==0){
			return false;
		}
		if(pattern==null || pattern.length()==0){
			return false;
		}
		if(i == input.length()){
			if(p == pattern.length()){
				return true;
			}else{
				return false;
			}
		}
		
		if(p == pattern.length()){
			return false;
		}
		
		char pc = pattern.charAt(p);
		if(pc == '.' ){
			return isMatching(input , pattern , i+1 , p+1);
		}else if(pc == '*'){
			for(int x = i; x<=input.length();x++){
				if(isMatching(input , pattern , x , p+1)){
					return true;
				}
			}
			return false;
		}else{
			if(input.charAt(i) != pc){
				return false;
			}
			return isMatching(input , pattern , i+1 , p+1);
		}
	}
	public static void main(String[] args) {
		String input= "aa";
		String pattern = ".*";
		System.out.println(isMatching(input,pattern , 0 , 0));
	}
}
