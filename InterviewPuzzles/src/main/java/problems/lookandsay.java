package problems;

public class lookandsay {

	public static void main(String[] args) {
		int input = 10;
		for(int i=1;i<input;i++)
		System.out.println(lookAndSay(i));
	}

	private static String lookAndSay(int input) {
		if(input == 1)  return "1";
		String value = lookAndSay(input-1);
		StringBuilder sb = new StringBuilder();
		char last = value.charAt(0);
		int count=1;
		for(int i=1;i<value.length();i++){
			if(last == value.charAt(i)){
				count++;
			}else{
				sb.append(count+""+last);
				last = value.charAt(i);
				count=1;
				
			}
		}
		sb.append(count+""+last);
		return sb.toString();
		
	}
}
