package DynamicProgramming;

public class PossibleDecodings {

	//FIXME do the DP version
	
	public static void main(String[] args) {
		String input= "1234";
		//3
		decoding(input, "");
	}
	
	private static void decoding(String input , String sofar){
		if(input.length() == 0){
			System.out.println(sofar);
			return;
		}
		int o = Integer.parseInt(input.charAt(0)+"");
		if(o != 0){
			decoding(input.substring(1), sofar+((char)('a'+o-1)));
			if(input.length() > 1){
				int t = Integer.parseInt(input.substring(0, 2));
				if(t<=26){
					decoding(input.substring(2), sofar+((char)('a'+t-1)));
				}
			}
		}else{
			return;
		}
			
		
	}
}
