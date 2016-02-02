package Recursion;

public class ValidIpAddressGeneration {

	public static void ip(String prefix , int index , int position, String leftOver){
		if(position > 4)
			return;
		
		if(leftOver.length() == index){
			System.out.println(prefix.substring(0,prefix.length()-1));
		}
		int length = leftOver.length();
		if(index < length){
			ip(prefix+leftOver.charAt(index)+".", index+1 ,position+1, leftOver);
		}
		
		if(index+1 < length){
			ip(prefix+leftOver.charAt(index)+leftOver.charAt(index+1)+".", index+2 ,position+1, leftOver);
		}
		
		if(index+2 < length){
			String data = leftOver.substring(index, index+3);
			if(Integer.parseInt(data) < 256){
				ip(prefix+data+".", index+3 ,position+1, leftOver);
			}
		}
		
	}
	public static void main(String[] args) {
		String input = "25525511";
		ip("",0,0,input);
	}
}
