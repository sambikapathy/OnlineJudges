import java.math.BigInteger;


public class Multiplication {

	public static void main(String[] args) {
		int start = 100;
		int end = 1000;
//		for(int i =start;i<end;i++){
//			for(int j=start;j<end;j++){
//				try{
//				String one = i*j+"";
//				String two = multiply(i+"", j+"");
//				if(!one.equals(two)){
//					System.out.println(i+"*"+j + " " + two);
//				}
//				else{
////					System.out.println(i+"*"+j + " " + two);
//				}
//				}catch(Exception ex){
////					System.out.println(i+" "+j);
//					ex.printStackTrace();
//				}
//			}
//		}
		System.out.println(multiply("1234567890", "1234567890"));
		BigInteger a = new BigInteger("1234567890");
		System.out.println(a.multiply(a));
	}
	//1524157875019052000
	
	static String multiply(String inp1 , String inp2){
//		String inp1 = "123";
//		String inp2 = "145";
		if(inp1.length()<inp2.length()){
			String temp = inp2;
			inp2 = inp1;
			inp1 = temp;
		}
		int [][]arrResult = new int[inp1.length()][inp1.length()+inp2.length()+1];
		int r=0 , c = arrResult[0].length-1;
		for(int i=inp2.length()-1;i>=0;i--){
			int ci = c;
			int ri = r;
			int co = 0;
			int f = inp2.charAt(i)-'0';
			for(int j=inp1.length()-1;j>=0;j--){
				int s = inp1.charAt(j) - '0';
				int result = f*s;
				int value = result+co;
				
				if(value>=10){
					co = value/10;
					value = value%10;
				}else{
					co = 0;
				}
				arrResult[ri][ci--]=value;
			}
			if(co > 0){
				arrResult[ri][ci--]=co;
				
			}
			//print(arrResult);
			r++ ; c--;
		}
		
		int total=0 , co=0;
		for (int i = arrResult[0].length-1; i>=0; i--) {
			for (int j = 0; j < arrResult.length; j++) {
				total+=arrResult[j][i];
			}
			total+=co;
			if(total>=0){
			co = total/10;
			}else{
				co=0;
			}
			arrResult[arrResult.length-1][i]=total%10;
			total=0;
		}
		
		StringBuilder sb = new StringBuilder();
		boolean isPrefix = true;
		for(int i=0;i<arrResult[0].length;i++){
			int value = arrResult[arrResult.length-1][i];
			if(isPrefix && value==0){
				continue;
			}else{
				isPrefix = false;
			}
			sb.append(value);
		}
		return (sb.toString());
//		print(arrResult);
		
	}
	static void print(int [][] arrResult){
		for(int i=0;i<arrResult.length;i++){
			for(int j=0;j<arrResult[0].length;j++){
				System.out.print(arrResult[i][j]+" ");
			}
			System.out.println();
			
		}
		System.out.println();
	}
}
