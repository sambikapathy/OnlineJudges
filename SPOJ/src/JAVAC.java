import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JAVAC {
	/*
	 * bad_Style J _java ja_va ja__va java_ ____ Java ja_Va JaVa
	 */

	public static void main(String[] args) throws java.lang.Exception {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String expr = in.readLine();
			if(expr == null){
				break;
			}
			boolean isC = isValidC(expr);
			boolean isJava = isValidJava(expr);
			if(isC && isJava){
				System.out.println(expr);
			}else if(isC){
				System.out.println(getJavaString(expr));
			}else if(isJava){
				System.out.println(getCString(expr));
			}else{
				System.out.println("Error!");
			}
			
		}

	}
	
	private static String getCString(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c>='A' && c<='Z'){
				sb.append("_");
				sb.append((char)(c-'A'+'a'));
			}else{
				sb.append(c);
			}
		}
		return sb.toString();
	}

	private static String getJavaString(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c=='_'){
				c = str.charAt(++i);
				//A-65 a - 97
				sb.append((char)('A'+(c-'a')));
			}else{
				sb.append(c);
			}
		}
		return sb.toString();
	}

	private static boolean isValidJava(String str){
		if(str.length() == 0){
			return false;
		}
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c>='A' && c<='Z'){
//				if(afterCaps){
//					return false;
//				}else{
//					afterCaps=true;
//				}
				if(i==0) return false;
			}else if(c=='_'){
				return false;
			}else if(c>='a' && c<='z'){
			}else{
				return false;
			}
		}
		return true;
	}
	
	private static boolean isValidC(String str){
		boolean afterUS = true;
		if(str.length() == 0){
			return false;
		}
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c>='a' && c<= 'z'){
				if(afterUS){
					afterUS = false;
				}
			}else if(c=='_'){
				if(afterUS){
					return false;
				}else{
					afterUS = true;
				}
			}else {
				return false;
			}
		}
		if(afterUS){
			return false;
		}
		return true;
	}
}
