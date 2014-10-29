package Div2Level250;

//DIV 1 250
public class ZigZag {
	
	public int longestZigZag(int[] seq){
		int []diff = new int[seq.length-1];
		for(int i=0;i<(seq.length-1);i++){
			diff[i] = seq[i]-seq[i+1];
		}
		
		for(int i=0;i<diff.length;i++){
			System.out.print(diff[i] +" ");
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int []seq = { 1, 7, 4, 9, 2, 5 };
		new ZigZag().longestZigZag(seq);
//		System.out.println(new ZigZag().longestZigZag(seq));
	}
}
