package problems;


public class NextBiggestInteger {

	public String nextBiggestInt(String input1) {
		int index = 0;
		StringBuilder sb = new StringBuilder(input1);
		while (index < sb.length() - 1) {
			int value = sb.charAt(index) - '0';
			int nextValue = sb.charAt(index + 1) - '0';
			// 123
			if (value < nextValue) {
				index++;
				continue;
			} else {
				int newValue = value + 1;
				// 145
				if (newValue < 10) {
					sb.setCharAt(index + 1, (char) ('0' + newValue));
					if((sb.length()-(index+2))<=(9-newValue)){
						index+=2;
						for (int i = newValue+1;index < sb.length() ; i++, index++) {
							sb.setCharAt(index, (char)(i+'0'));
						}
						return sb.toString();
					}
					index++;
				} else {
					// 14891
					// 15111
					// 15678
					if (index > 0) {
						while (index > 0) {
							int pv = sb.charAt(index - 1) - '0';
							if (pv + 1 < 10) {
								sb.setCharAt(index - 1, (char) ('0' + (pv + 1)));
								if((sb.length()-(index))<=(9-(pv+1))){
									for (int i = pv+2;index < sb.length() ; i++, index++) {
										sb.setCharAt(index, (char)(i+'0'));
									}
									return sb.toString();
								}
								index--;
								break;
							}
						}
					} else {
						if (input1.length() + 1 < 10) { // check this
							StringBuilder sb1 = new StringBuilder();
							for (int i = 1; i <= input1.length() + 1; i++) {
								sb1.append((char) ('0' + i));
							}
							return sb1.toString();
						}
					}
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
//		new NextBiggestInteger().testPlusOne();
		String input = "6879";
		int start = 9999;
		int end = 99999;
		int count = 0;
		for(int i =start;i<end;i++){
			String op1 = new NextBiggestInteger().nextBiggestInt( new NextBiggestInteger().getPlusOne(String.valueOf(i)));
			String op2 = String.valueOf(new NextBiggestInteger().nextInteger(i));
			if(!op1.equals(op2)){
				System.out.println(i+" "+op1+" "+op2);
				count++;
			}
		}
		System.out.println("Count is "+ count);
		
	}
	
	private String getPlusOne(String input){
		StringBuilder sb  = new StringBuilder(input);
		int index = input.length()-1;
		while(index >= 0){
			int cv = sb.charAt(index)-'0';
			if(cv+1 < 10){
				sb.setCharAt(index, (char)(cv+1+'0'));
				return sb.toString();
			}else{
				sb.setCharAt(index, (char)('0'));
				index--;
			}
		}
		sb.setCharAt(0, '1');
		sb.append('0');
		return sb.toString();
	}
	
	
	public int nextInteger(int value) {
		value++;
		while (!isIncreasing(value)) {
			value++;
		}
		return value;
	}

	private boolean isIncreasing(int value) {
		String input = value + "";
		int min = 0;
		for (int i = 0; i < input.length(); i++) {
			int cv = '0' + input.charAt(i);
			if (min < cv) {
				min = cv;
			} else {
				return false;
			}
		}
		return true;
	}
	
	
//	private void testPlusOne(){
//		int start = 9999;
//		int end = 999999;
//		for(int i=start;i<=end;i++){
//			int val = i+1;
//			int val2  = Integer.parseInt(getPlusOne(String.valueOf(i))); 
//			if(val != val2){
//				System.out.println("Not Equal "+ i +" "+ val+" "+val2);
//			}
//		}
//	}
}
