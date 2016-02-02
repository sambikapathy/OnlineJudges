package Arrays;

public class ByteArray {

	public static void main(String[] args) {
		byte[] input = new byte[10];
		for(int i=0;i<10;i++){
			input[i] = (byte) i;
		}
		for(byte i : input){
			System.out.println(i);
		}
	}
}
