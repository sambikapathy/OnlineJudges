package Recursion;

public class GenerateParanthesis {

	/*
	 (())
	 ()()
	 
	 */
	private static void generate(String prefix , int size , int l , int r) {
		if(size == 0){
			if(l==r)
			System.out.println(prefix);
			return;
		}
		if(r > l){
			return;
		}
		generate(prefix+"(" , size-1 , l+1 , r);
		generate(prefix+")" , size-1 , l , r+1);
	}
	
	
	public static void main(String[] args) {
		int size = 3;
		generate("",size*2,0,0);
	}

	
}
