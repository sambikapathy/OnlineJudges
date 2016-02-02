package interviewbit;

public class EXCEL2 {

	public static void main(String[] args) {
		EXCEL2 x = new EXCEL2();
		for(int i=1;i<29;i++){
			System.out.println(x.convertToTitle(i));
		}
	}
	public String convertToTitle(int a) {
		StringBuilder str = new StringBuilder();
		while(a > 0){
			a--;
			int rem = a%26;
//			if(rem==0) rem = 26;
			str.append((char)('A'+rem));
			a /=26;
		}
		return str.reverse().toString();
	}
}
