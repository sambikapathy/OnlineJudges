
public class P17NumberLetterCounts {

	static String oneToTwenty = 
			"one, two, three, four, five, six, seven, eight, nine, ten,"
			+ "eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty";
	
	static String tens = "ten , twenty , thirty, forty, fifty, sixty, seventy, eighty , ninety";
	static String hundred = "hundred";
	static String thousand = "thousand";
	
	public static void main(String[] args) {
		String []twenty = new String[20];
		String [] tensArray = new String[10];
		int index = 0;
		for(String str : oneToTwenty.split(",")){
			twenty[index++] = str.trim();
		}
		index = 0;
		
		for(String str : tens.split(",")){
			tensArray[index++] = str.trim();
		}
		int total = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<1000;i++){
			int third = i/100;
			int second = i%100;
			int first = i%10;
			
			if (i <= 20) {
				System.out.println(twenty[i-1]);
				sb.append(twenty[i-1]);
			} else {
				if (third > 0) {
					if(i%100 != 0){
						System.out.print(twenty[third-1] +" "+hundred+ " and ");
					sb.append(twenty[third-1] +hundred+ "and");
					}
					else{
						System.out.println(twenty[third-1] +" "+hundred);
						sb.append(twenty[third-1] +hundred);
						continue;
					}
				}
				if (second <= 20) {
					System.out.println(twenty[second - 1]);
					sb.append(twenty[second - 1]);
				} else {
					if (second > 9) {
						if (second % 10 == 0) {
							System.out.println(tensArray[(second / 10) - 1]
									+ " ");
							sb.append(tensArray[(second / 10) - 1]);
							continue;
						} else {
							System.out
									.print(tensArray[(second / 10) - 1] + " ");
							sb.append(tensArray[(second / 10) - 1]);
						}
					}
					if(first >0){
						System.out.println(twenty[first-1]);
						sb.append(twenty[first-1]);
					}
				}
				
			}

		}
		System.out.println(sb.length());
	}
}
