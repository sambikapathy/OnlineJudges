package Recursion;

public class RandomWordsFromCharacters {

	private static final int length = 2;
	static int size = 0;
	public static void random(String data){
		if(data.length() == length){
			size++;
			System.out.println(data);
			return;
		}
		for(int i=0;i<26;i++){
			char c = (char)('a'+i);
			random(data+c);
		}
	}
	
	public static void main(String[] args) {
		random("");
		System.out.println(size);
	}
}
